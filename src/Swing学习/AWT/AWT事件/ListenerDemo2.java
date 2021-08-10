package Swing学习.AWT.AWT事件;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListenerDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试WindowListener");
        frame.setBounds(200,200,500,300);
        //设置WindowListener，监听用户点击X的动作，如果点击X，则关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前程序
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
