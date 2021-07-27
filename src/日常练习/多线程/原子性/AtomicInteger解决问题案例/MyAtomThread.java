package 日常练习.多线程.原子性.AtomicInteger解决问题案例;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomThread implements Runnable{
    //private volatile int count = 0;
    //private Object lock = new Object();
    AtomicInteger ac = new AtomicInteger(0);


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int count = ac.incrementAndGet();
            System.out.println("已经送了" + count + "个冰淇淋");
        }
    }
}
