package Swing学习.Swing.基本组件用法;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JToolBarTest {

    JFrame jf = new JFrame("测试工具条");

    JTextArea jta = new JTextArea(6,35);
    //创建工具条
    JToolBar jtb = new JToolBar();

    //创建"上一曲"Action,该Action用于创建工具按钮
    Action pre = new AbstractAction("上一曲") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("上一曲.\n");
        }
    };

    //创建"暂停" Action
    Action pause = new AbstractAction("暂停") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("暂停播放.\n");
        }
    };

    // 创建"下一曲" Action
    Action next = new AbstractAction("下一曲") {
        @Override
        public void actionPerformed(ActionEvent e) {
            jta.append("下一曲.\n");
        }
    };

    public void init(){

        //给JTextArea添加滚动条
        jf.add(new JScrollPane(jta));

        //以Action的形式创建按钮，并将按钮添加到Panel中
        JButton preBtn = new JButton(pre);
        JButton pauseBtn = new JButton(pause);
        JButton nextBtn = new JButton(next);


        //往工具条中添加Action对象，该对象会转换成工具按钮
        jtb.add(preBtn);
        jtb.addSeparator();
        jtb.add(pauseBtn);
        jtb.addSeparator();
        jtb.add(nextBtn);

        //向窗口中添加工具条
        jf.add(jtb,BorderLayout.NORTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new JToolBarTest().init();
    }
}
