package 日常练习.多线程.线程池.volatile问题.synchronized解决;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Money.lock){
                if (Money.money != 100000){
                    System.out.println("结婚基金已经不是十万了");
                    break;
                }
            }
        }
    }
}
