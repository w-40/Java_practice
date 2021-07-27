package 日常练习.多线程.线程池.volatile问题.synchronized解决;

public class MyThread2 extends Thread{
    @Override
    public void run() {
        synchronized (Money.lock) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Money.money = 90000;
        }
    }
}
