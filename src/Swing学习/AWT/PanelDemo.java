package Swing学习.AWT;

import java.awt.*;

public class PanelDemo {
    public static void main(String[] args) {
        //1.创建一个window对象，因为panel以及其他的容器，都不能独立存在，必须依附于window存在
        Frame frame = new Frame("这里演示Panel");
        //2.创建一个panel对象
        Panel p = new Panel();
        //3.创建一个文本框和一个按钮，并且把他们放到panel容器中
        p.add(new TextField("这里是一个测试文本"));
        p.add(new Button("这里是一个测试按钮"));
        //4.把panel放到window中
        frame.add(p);
        //5.设置window位置以及大小
        frame.setBounds(100,100,500,300);
        //6.使window可见
        frame.setVisible(true);
    }
}
