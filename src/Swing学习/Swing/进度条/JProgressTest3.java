package Swing学习.Swing.进度条;
//MVC
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JProgressTest3 {

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

        //开启耗时任务
        SimulatedActivity simulatedActivity = new SimulatedActivity(100);
        new Thread(simulatedActivity).start();


        //设置进度条的最大值和最小值
        bar.getModel().setMinimum(0);
        bar.getModel().setMaximum(simulatedActivity.getAmount());

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




        //通过定时器，不断的读取simulatedActivity中的current值，更新进度条的进度
        Timer timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bar.getModel().setValue(simulatedActivity.getCurrent());
            }
        });
        timer.start();
        //监听进度条的变化，如果进度完成为100%，那么停止定时器
        bar.getModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (   bar.getModel().getValue()==bar.getModel().getMaximum()){
                    timer.stop();
                }
            }
        });


    }

    public static void main(String[] args) {
        new JProgressTest3().init();
    }

    //定义一个线程任务，模拟耗时操作
    private class SimulatedActivity implements Runnable{
        //内存可见
        private volatile int current = 0;
        private int amount;

        public SimulatedActivity(int amount) {
            this.amount = amount;
        }

        public int getCurrent() {
            return current;
        }

        public void setCurrent(int current) {
            this.current = current;
        }


        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override
        public void run() {
            //通过循环，不断的修改current的值，模拟任务完成量
            while(current<amount){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                current++;
            }
        }
    }
}