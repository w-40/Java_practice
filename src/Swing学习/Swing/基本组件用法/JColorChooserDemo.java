package Swing学习.Swing.基本组件用法;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JColorChooserDemo {

    JFrame jFrame = new JFrame("测试颜色选择器");

    JTextArea jta = new JTextArea("我爱中华",6,30);

    JButton button = new JButton(new AbstractAction("改变文本框的本景色"){

        @Override
        public void actionPerformed(ActionEvent e) {

            //弹出颜色选择器
            Color result = JColorChooser.showDialog(jFrame, "颜色选择器", Color.WHITE);
            jta.setBackground(result);
        }
    });

    public void init(){
        jFrame.add(jta);

        jFrame.add(button,BorderLayout.SOUTH);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new JColorChooserDemo().init();
    }

}

