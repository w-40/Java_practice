package 日常练习.多线程.线程池;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "在执行了");
    }
}
