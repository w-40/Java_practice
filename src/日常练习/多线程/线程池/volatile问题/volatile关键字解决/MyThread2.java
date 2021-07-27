package 日常练习.多线程.线程池.volatile问题.volatile关键字解决;

public class MyThread2 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Money.money = 90000;
    }
}
