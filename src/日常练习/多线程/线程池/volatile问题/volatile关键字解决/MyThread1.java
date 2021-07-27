package 日常练习.多线程.线程池.volatile问题.volatile关键字解决;

public class MyThread1 extends Thread{
    @Override
    public void run() {
        while (Money.money == 100000){

        }
        System.out.println("结婚基金已经不是十万了");
    }
}
