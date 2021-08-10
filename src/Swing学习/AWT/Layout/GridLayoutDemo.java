package Swing学习.AWT.Layout;

import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("计算器");
        //1.创建一个Panel对象，里面存放一个TextFiled组件
        Panel p = new Panel();
        p.add(new TextField(30));
        //2.把当前这个Panel添加到frame的北边区域
        frame.add(p,BorderLayout.NORTH);
        //3.创建一个Panel对象，并且设置它的布局管理器为GridLayoutDemo
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(3,5,4,4));

        //4.往Panel中添加内容
        for (int i = 0; i < 10; i++) {
            p2.add(new Button(i + ""));
        }
        p2.add(new Button("+"));
        p2.add(new Button("-"));
        p2.add(new Button("*"));
        p2.add(new Button("/"));
        p2.add(new Button("."));
        //5.把当前Panel添加到frame中
        frame.add(p2);

        frame.pack();
        frame.setVisible(true);
    }
}
