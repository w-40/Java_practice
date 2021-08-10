package Swing学习.列表框;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

public class ListTest {
    JFrame mainWin = new JFrame("列表框测试");
    String[] books = {"java自学宝典","轻量级javaEE企业应用实战","Android基础教程","jQuery实战教程","SpringBoot企业级开发"};

    //用一个字符串数组来创建一个JList对象
    JList<String> bookList = new JList<>(books);
    JComboBox<String> bookSelector;

    //定义 布局选择按钮 所在的面板
    JPanel layoutPanel = new JPanel();
    ButtonGroup layoutGroup = new ButtonGroup();

    //定义 选择模式按钮 所在面板
    JPanel selectModePanel = new JPanel();
    ButtonGroup selectModeGroup = new ButtonGroup();

    JTextArea favorite = new JTextArea(4,40);

    public void init(){
        //设置JList的可视高度可以同时展示3个列表项
        bookList.setVisibleRowCount(3);

        //设置Jlist默认选中第三项到第五项
        bookList.setSelectionInterval(2,4);
        addLayoutButton("纵向滚动",JList.VERTICAL);
        addLayoutButton("纵向换行",JList.VERTICAL_WRAP);
        addLayoutButton("横向换行",JList.HORIZONTAL_WRAP);

        addSelectModeButton("无限制", ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addSelectModeButton("单选", ListSelectionModel.SINGLE_SELECTION);
        addSelectModeButton("单范围", ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        Box listBox = Box.createVerticalBox();
        //将JList组件放置到JScrollPane中，并将JScrollPane放置到box中
        listBox.add(new JScrollPane(bookList));
        listBox.add(layoutPanel);
        listBox.add(selectModePanel);

        //为JList添加事件监听器
        bookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                List<String> selectedValuesList = bookList.getSelectedValuesList();
                favorite.setText("");
                for (String s : selectedValuesList) {
                    favorite.append(s+"\n");
                }
            }
        });


        //定义一个Vector对象
        Vector<String> bookCollection = new Vector<>();
        List<String> books = List.of("java自学宝典","轻量级javaEE企业应用实战","Android基础教程","jQuery实战教程","SpringBoot企业级开发");
        bookCollection.addAll(books);

        //创建JComboBox对象
        bookSelector = new JComboBox<>(bookCollection);

        //为JComboBox添加事件监听器
        bookSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object selectedItem = bookSelector.getSelectedItem();
                favorite.setText(selectedItem.toString());
            }
        });

        //设置JComboBox的列表项可编辑
        bookSelector.setEditable(true);

        //设置下拉列表的可视高度最多显示4个列表项
        bookSelector.setMaximumRowCount(4);

        JPanel panel = new JPanel();
        panel.add(bookSelector);
        Box box = Box.createHorizontalBox();
        box.add(listBox);
        box.add(panel);

        JPanel favoritePanel = new JPanel();
        favoritePanel.setLayout(new BorderLayout());
        favoritePanel.add(new JScrollPane(favorite));
        favoritePanel.add(new JLabel("您最喜欢的图书："),BorderLayout.NORTH);

        mainWin.add(box);
        mainWin.add(favoritePanel,BorderLayout.SOUTH);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);

    }



    public void addLayoutButton(String label,int orientation){
        layoutPanel.setBorder(new TitledBorder(new EtchedBorder(),"确定选项布局"));

        JRadioButton button = new JRadioButton(label);

        layoutPanel.add(button);
        //默认选中第一个按钮
        if (layoutGroup.getButtonCount()==0){
            button.setSelected(true);
        }
        layoutGroup.add(button);
        button.addActionListener(e->{
            //改变列表框里列表项的布局方向
            bookList.setLayoutOrientation(orientation);
        });

    }

    public void addSelectModeButton(String label,int selectMode){
        selectModePanel.setBorder(new TitledBorder(new EtchedBorder(),"确定选择模式"));
        JRadioButton button = new JRadioButton(label);
        selectModePanel.add(button);
        if (selectModeGroup.getButtonCount()==0){
            button.setSelected(true);
        }
        selectModeGroup.add(button);
        button.addActionListener(e->{
            bookList.setSelectionMode(selectMode);
        });


    }

    public static void main(String[] args) {
        new ListTest().init();
    }
}