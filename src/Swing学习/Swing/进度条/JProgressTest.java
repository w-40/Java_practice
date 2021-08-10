package Swing学习.Swing.进度条;
//for模拟
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JProgressTest {

    JFrame jf = new JFrame("测试进度条");
    //创建一个垂直进度条
    JProgressBar bar = new JProgressBar(JProgressBar.HORIZONTAL);

    JCheckBox indeterminate = new JCheckBox("不确定进度");
    JCheckBox noBorder = new JCheckBox("不绘制边框");

    public void init(){

        Box box = new Box(BoxLayout.Y_AXIS);
        box.add(indeterminate);
        box.add(noBorder);

        jf.setLayout(new FlowLayout());
        jf.add(box);

        //把进度条添加到jf窗口中
        jf.add(bar);

        //设置进度条的最大值和最小值
        bar.setMinimum(0);
        bar.setMaximum(100);

        //设置进度条中绘制完成百分比
        bar.setStringPainted(true);

        //根据选择决定是否绘制进度条边框
        noBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = noBorder.isSelected();
                bar.setBorderPainted(!flag);
            }
        });

        //根据选择决定是否是不确定进度条
        indeterminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = indeterminate.isSelected();
                bar.setIndeterminate(flag);
                //不绘制百分比，因为之前设置了绘制百分比
                bar.setStringPainted(!flag);
            }
        });

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);


        //通过循环不断改变进度条的完成进度
        for (int i = 0; i <= 100; i++) {
            //改变进度条的完成进度
            bar.setValue(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new JProgressTest().init();
    }
}
