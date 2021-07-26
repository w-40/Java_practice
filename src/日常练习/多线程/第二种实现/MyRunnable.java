package 日常练习.多线程.第二种实现;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("第二种方法实现多线程" + i);
        }
    }
}
