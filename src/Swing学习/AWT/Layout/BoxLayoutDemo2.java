package Swing学习.AWT.Layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试BoxLayout");

        //1.创建一个水平排列组件的Box容器
        Box hBox = Box.createHorizontalBox();
        //2.往当前容器中添加两个按钮
        hBox.add(new Button("水平按钮1"));
        hBox.add(new Button("水平按钮2"));
        //3.创建一个垂直排列组件的Box容器
        Box vBox = Box.createVerticalBox();
        //4.往当前容器中添加两个按钮
        vBox.add(new Button("垂直按钮1"));
        vBox.add(new Button("垂直按钮2"));
        //5.把两个Box容器添加到Frame中展示
        frame.add(hBox,BorderLayout.NORTH);
        frame.add(vBox);


        frame.pack();
        frame.setVisible(true);
    }
}
