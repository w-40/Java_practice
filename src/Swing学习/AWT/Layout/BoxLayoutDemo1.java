package Swing学习.AWT.Layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试BoxLayout");

        //1.基于frame容器，创建一个BoxLayout对象，并且，该对象存放组件是垂直存放
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.Y_AXIS);//垂直存放
        //2.把BoxLayout对象设置给Frame
        frame.setLayout(boxLayout);
        //3.往frame中添加两个按钮组件
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));
        frame.pack();
        frame.setVisible(true);
    }
}
