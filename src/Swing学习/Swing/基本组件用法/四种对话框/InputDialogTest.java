package Swing学习.Swing.基本组件用法.四种对话框;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InputDialogTest {


    JFrame jf = new JFrame("测试输入对话框");

    JTextArea jta = new JTextArea(6, 30);

    JButton btn = new JButton(new AbstractAction("弹出输入对话框") {

        @Override
        public void actionPerformed(ActionEvent e) {


           /* String result = JOptionPane.showInputDialog(jf, "请填写您的银行账号：", "输入对话框", JOptionPane.INFORMATION_MESSAGE);
            if(result!=null){
                jta.append(result.toString());
            }
            */

            Object result = JOptionPane.showInputDialog(jf, "", "输入对话框", JOptionPane.DEFAULT_OPTION, null, new String[]{"柳岩", "舒淇", "龚玥菲"}, "舒淇");
            if (result!=null){
                jta.append(result.toString());
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
        new InputDialogTest().init();
    }

}

