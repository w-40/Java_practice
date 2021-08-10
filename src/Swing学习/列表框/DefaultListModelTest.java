package Swing学习.列表框;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DefaultListModelTest {

    JFrame mainWin = new JFrame("测试DefaultListModel");

    //定义一个JList对象
    JList<String> bookList;
    //定义一个DefaultListModel对象
    DefaultListModel<String> bookModel = new DefaultListModel<>();

    JTextField bookName = new JTextField(20);

    JButton removeBtn = new JButton("删除选中图书");
    JButton addBtn = new JButton("添加指定图书");

    public void init(){
        //向bookModel中添加元素
        bookModel.addElement("java自学宝典");
        bookModel.addElement("轻量级javaEE企业应用实战");
        bookModel.addElement("Android基础教程");
        bookModel.addElement("jQuery实战教程");
        bookModel.addElement("SpringBoot企业级开发");

        //根据DefaultListModel创建一个JList对象
        bookList = new JList<>(bookModel);
        //设置最大可视高度
        bookList.setVisibleRowCount(4);

        //设置只能单选
        bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //为addBtn添加事件监听器
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //当bookName文本框内容不为空时添加列表项
                if (!bookName.getText().trim().equals("")){

                    bookModel.addElement(bookName.getText());
                }

            }
        });

        //为removeBtn添加事件监听器
        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = bookList.getSelectedIndex();
                if (selectedIndex>=0){

                    bookModel.remove(selectedIndex);
                }
            }
        });

        JPanel p = new JPanel();
        p.add(bookName);
        p.add(addBtn);
        p.add(removeBtn);

        mainWin.add(new JScrollPane(bookList));
        mainWin.add(p, BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);

    }

    public static void main(String[] args) {
        new DefaultListModelTest().init();
    }

}

