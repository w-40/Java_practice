package Swing学习.Swing.基本组件用法.四种对话框;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfirmDialogTest {


    JFrame jf = new JFrame("测试确认对话框");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("弹出确认对话框") {

        @Override
        public void actionPerformed(ActionEvent e) {

            int result = JOptionPane.showConfirmDialog(jf, jta.getText(), "确认对话框",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION){
                jta.append("\n用户点击了确定按钮");
            }

            if (result==JOptionPane.NO_OPTION){
                jta.append("\n用户点击了取消按钮");
            }

        }
    });


    public void init(){
        jf.add(jta);
        jf.add(btn, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new ConfirmDialogTest().init();
    }

}
