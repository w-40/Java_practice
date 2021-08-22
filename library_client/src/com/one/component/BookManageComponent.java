package com.one.component;

import com.one.domain.ResultInfo;
import com.one.listener.ActionDoneListener;
import com.one.net.FailListener;
import com.one.net.GetUtils;
import com.one.net.SuccessListener;
import com.one.util.JsonUtils;
import com.one.util.ResultInfoData2Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BookManageComponent extends Box {
    final int WIDTH = 850;
    final int HEIGHT = 600;

    JFrame jf = null;
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableData;
    private TableModel tableModel;

    public BookManageComponent(JFrame jf){
        //垂直布局
        super(BoxLayout.Y_AXIS);

        //组装视图
        JPanel btnPanel = new JPanel();
        Color color = new Color(203, 220, 217);
        btnPanel.setBackground(color);
        btnPanel.setMaximumSize(new Dimension(WIDTH,80));
        btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton addBtn = new JButton("添加");
        JButton updateBtn = new JButton("修改");
        JButton deleteBtn = new JButton("删除");

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出一个对话框，让用户输入图书的信息
                new AddBookDialog(jf, "添加图书", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
                        requestdata();
                    }
                }).setVisible(true);
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前表格选中的id
                int selectedRow = table.getSelectedRow();//如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1
                if (selectedRow == -1){
                    JOptionPane.showMessageDialog(jf,"请选择要修改的条目：");
                    return;
                }
                String id = tableModel.getValueAt(selectedRow, 0).toString();


                //弹出一个对话框，让用户修改
                new UpdateBookDialog(jf, "修改图书", true, new ActionDoneListener() {
                    @Override
                    public void done(Object result) {
                        requestdata();
                    }
                },id).setVisible(true);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();//如果有选中的条目，则返回条目的行号，如果没有选中，那么返回-1
                if (selectedRow == -1){
                    JOptionPane.showMessageDialog(jf,"请选择要删除的条目：");
                    return;
                }
                //防止误操作
                int result = JOptionPane.showConfirmDialog(jf, "确认要删除选中的条目吗", "确认删除", JOptionPane.YES_NO_OPTION);
                if (result != JOptionPane.YES_OPTION){
                    return;
                }
                String id = tableModel.getValueAt(selectedRow, 0).toString();

                GetUtils.get("http://localhost:8080/book/deleteBookById?id=" + id, new SuccessListener() {
                    @Override
                    public void success(String result) {
                        ResultInfo info = JsonUtils.parseResult(result);
                        if (info.isFlag()){
                            //删除成功
                            JOptionPane.showMessageDialog(jf,"删除成功");
                            requestdata();
                        }else{
                            //删除失败
                            JOptionPane.showMessageDialog(jf,info.getMessage());
                        }
                    }
                }, new FailListener() {
                    @Override
                    public void fail() {
                        JOptionPane.showMessageDialog(jf,"网络异常，请稍后重试");
                    }
                });
            }
        });


        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);

        this.add(btnPanel);

        //组装表格
        String[] ts = {"编号","书名","简介","作者","价格","库存"};
        titles = new Vector<>();
        for (String title : ts) {
            titles.add(title);
        }

        tableData = new Vector<>();

        tableModel = new DefaultTableModel(tableData,titles);
        table = new JTable(tableModel){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //设置只能选中一行
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);

        requestdata();
    }
    //请求数据
    public void requestdata(){
        GetUtils.get("http://localhost:8080/book/findAllBook", new SuccessListener() {
            @Override
            public void success(String result) {
                ResultInfo info = JsonUtils.parseResult(result);
                Vector<Vector> vectors = ResultInfoData2Vector.convertResultInfoData2Vector(info);

                //清空tableData的数据
                tableData.clear();
                for (Vector vector : vectors) {
                    tableData.add(vector);
                }
                //刷新表格
               // tableModel.fireTableDataChanged();

            }
        }, new FailListener() {
            @Override
            public void fail() {
            }
        });
    }

}
