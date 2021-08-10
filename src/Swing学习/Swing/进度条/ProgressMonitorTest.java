package Swing学习.Swing.进度条;
//进度对话框
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressMonitorTest {

    Timer timer;
    public void init(){
        final SimulatedActivity simulatedActivity = new SimulatedActivity(100);
        final Thread targetThread= new Thread(simulatedActivity);
        targetThread.start();


        ProgressMonitor dialog = new ProgressMonitor(null, "等待任务完成", "已完成：", 0, simulatedActivity.getAmount());

        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setProgress(simulatedActivity.getCurrent());
                if (dialog.isCanceled()){
                    timer.stop();
                    targetThread.interrupt();
                    System.exit(0);
                }
            }
        });
        timer.start();


        System.out.println("aaa");
    }

    public static void main(String[] args) {
        new ProgressMonitorTest().init();
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