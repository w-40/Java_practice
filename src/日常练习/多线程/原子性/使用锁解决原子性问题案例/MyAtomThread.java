package 日常练习.多线程.原子性.使用锁解决原子性问题案例;

public class MyAtomThread implements Runnable{
    private volatile int count = 0;
    private Object lock = new Object();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (lock){
                count++;
                System.out.println("已经送了" + count + "个冰淇淋");
            }
        }
    }
}
