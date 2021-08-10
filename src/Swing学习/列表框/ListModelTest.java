package Swing学习.列表框;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.List;

public class ListModelTest {
    JFrame mainWin = new JFrame("测试ListModel");

    //根据NumberListModel对象创建一个JList
    JList<BigDecimal> numScopeList = new JList<>(new NumberListModel(1,21,2));

    //根据NumberComboBoxModel对象创建一个JComboBox
    JComboBox<BigDecimal> numScopeSelector = new JComboBox<>(new NumberComboBoxModel(0.1,1.2,0.1));

    JTextField showVal = new JTextField(10);

    public void init(){
        //JList可视高度可同时显示四个列表项
        numScopeList.setVisibleRowCount(4);

        //默认选中第三项到第五项
        numScopeList.setSelectionInterval(2,4);

        //设置每个列表项具有指定高度和宽度
        numScopeList.setFixedCellHeight(30);
        numScopeList.setFixedCellWidth(90);

        //为numScopeList添加监听器
        numScopeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //获取用户选中的所有数字
                List<BigDecimal> selectedValuesList = numScopeList.getSelectedValuesList();
                showVal.setText("");
                for (BigDecimal bigDecimal : selectedValuesList) {
                    showVal.setText(showVal.getText()+bigDecimal.toString()+", ");
                }
            }
        });

        //设置下拉列表的可视高度可显示5个列表项
        numScopeSelector.setMaximumRowCount(5);

        Box box = Box.createHorizontalBox();
        box.add(new JScrollPane(numScopeList));

        JPanel p = new JPanel();
        p.add(numScopeSelector);
        box.add(p);

        //为numberScopeSelector添加监听器
        numScopeSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object value = numScopeSelector.getSelectedItem();
                showVal.setText(value.toString());
            }
        });


        JPanel bottom = new JPanel();
        bottom.add(new JLabel("您选择的值是："));
        bottom.add(showVal);

        mainWin.add(box);
        mainWin.add(bottom, BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);

    }

    public static void main(String[] args) {
        new ListModelTest().init();
    }
}
