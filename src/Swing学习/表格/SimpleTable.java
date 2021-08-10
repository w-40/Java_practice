package Swing学习.表格;

import javax.swing.*;

public class SimpleTable {

    JFrame jf = new JFrame("简单表格");

    JTable table;

    //定义二维数组作为表格数据

    Object[][] tableData = {

            new Object[]{"李清照",29,"女"},
            new Object[]{"苏格拉底",56,"男"},
            new Object[]{"李白",35,"男"},
            new Object[]{"弄玉",18,"女"},
            new Object[]{"虎头",2,"男"},

    };

    //定义一个一维数组，作为列标题
    Object[] columnTitle = {"姓名","年龄","性别"};

    public void init(){
        //以二维数组和一维数组来创建一个JTable对象

        table = new JTable(tableData,columnTitle);

        jf.add(new JScrollPane(table));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleTable().init();
    }
}
