package Swing学习.表格;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;

public class DefaultTableModelTest {

    JFrame mainWin = new JFrame("管理数据行、数据列");

    final int COLUMN_COUNT = 5;

    DefaultTableModel model;

    JTable table;
    //用于保存被隐藏列的List集合
    ArrayList<TableColumn> hiddenColumns = new ArrayList<>();

    public void init(){

        //创建DefaultTableModel，5行5列
        model = new DefaultTableModel(COLUMN_COUNT,COLUMN_COUNT);

        //给每个单元格设置内容
        for (int i = 0; i < COLUMN_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                model.setValueAt("老单元格值"+i+" "+j,i,j);

            }
        }

        //创建表格
        table = new JTable(model);
        mainWin.add(new JScrollPane(table), BorderLayout.CENTER);

        //为窗口安装菜单
        JMenuBar menuBar = new JMenuBar();
        mainWin.setJMenuBar(menuBar);
        JMenu tableMenu = new JMenu("管理");
        menuBar.add(tableMenu);

        JMenuItem hideColumnsItem = new JMenuItem("隐藏选中列");
        hideColumnsItem.addActionListener(e -> {
            //获取所有选中列的索引
            int[] selectedColumns = table.getSelectedColumns();
            TableColumnModel columnModel = table.getColumnModel();
            //依次把每个选中的列隐藏起来，并使用hideColumns集合把隐藏的列保存起来

            for (int i = 0; i < selectedColumns.length; i++) {
                //获取列对象TableColumn
                TableColumn column = columnModel.getColumn(selectedColumns[i]);
                //隐藏指定列
                table.removeColumn(column);

                //把隐藏的列保存起来，确保以后可以显示出来
                hiddenColumns.add(column);
            }
        });

        tableMenu.add(hideColumnsItem);

        JMenuItem showColumsItem = new JMenuItem("显示隐藏列");
        showColumsItem.addActionListener(e -> {

            for (TableColumn column : hiddenColumns) {
                table.addColumn(column);
            }

            //清空隐藏列集合
            hiddenColumns.clear();

        });

        tableMenu.add(showColumsItem);

        JMenuItem addColumnItem = new JMenuItem("插入选中列");
        addColumnItem.addActionListener(e -> {
            //获取所有选中列的索引
            int[] selectedColumns = table.getSelectedColumns();
            TableColumnModel columnModel = table.getColumnModel();
            //依次插入选中列
            for (int i = selectedColumns.length-1; i >=0; i--) {
                TableColumn column = columnModel.getColumn(selectedColumns[i]);
                table.addColumn(column);

            }
        });

        tableMenu.add(addColumnItem);


        JMenuItem addRowItem = new JMenuItem("增加行");
        addRowItem.addActionListener(e -> {
            //创建一个String数组，作为新增行的内容
            String[] newCells = new String[COLUMN_COUNT];
            for (int i = 0; i < newCells.length; i++) {
                newCells[i] = "新单元格的值"+model.getRowCount()+" "+i;
            }

            //向table中新增一行
            model.addRow(newCells);
        });

        tableMenu.add(addRowItem);

        JMenuItem removeRowsItem = new JMenuItem("删除选中行");

        removeRowsItem.addActionListener(e -> {
            //获取被选中的行
            int[] selectedRows = table.getSelectedRows();

            //依次删除每一行
            for (int i = selectedRows.length-1; i >=0; i--) {
                model.removeRow(selectedRows[i]);
            }

        });

        tableMenu.add(removeRowsItem);

        mainWin.pack();
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.setVisible(true);

    }


    public static void main(String[] args) {
        new DefaultTableModelTest().init();
    }

}
