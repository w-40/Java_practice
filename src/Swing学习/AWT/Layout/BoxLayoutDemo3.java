package Swing学习.AWT.Layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试BoxLayout");

        //1.创建水平排列的Box容器 hBox
        Box hBox = Box.createHorizontalBox();
        //2.往hBox容器中添加按钮，还需要在多个按钮之间添加分割
        hBox.add(new Button("水平按钮一"));
        hBox.add(Box.createHorizontalGlue());//该分割在两个方向上都可以拉伸
        hBox.add(new Button("水平按钮二"));
        hBox.add(Box.createHorizontalStrut(30));
        hBox.add(new Button("水平按钮三"));
        //3.创建垂直排列的Box容器 vBox
        Box vBox = Box.createVerticalBox();
        //4.往vBox容器中添加按钮，还需要在多个按钮之间添加分割
        vBox.add(new Button("垂直按钮一"));
        vBox.add(Box.createVerticalGlue());
        vBox.add(new Button("垂直按钮二"));
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(new Button("垂直按钮三"));

        //5.把Box容器添加到frame中
        frame.add(hBox,BorderLayout.NORTH);
        frame.add(vBox);//默认中间

        frame.pack();
        frame.setVisible(true);
    }
}
