package Swing学习.Swing.基本组件用法.四种对话框;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MessageDialogTest {


    JFrame jf = new JFrame("测试消息对话框");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("弹出消息对话框") {

        @Override
        public void actionPerformed(ActionEvent e) {
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.INFORMATION_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.QUESTION_MESSAGE);
            JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.PLAIN_MESSAGE);
            //JOptionPane.showMessageDialog(jf, jta.getText(), "消息对话框", JOptionPane.WARNING_MESSAGE);

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
        new MessageDialogTest().init();
    }

}

