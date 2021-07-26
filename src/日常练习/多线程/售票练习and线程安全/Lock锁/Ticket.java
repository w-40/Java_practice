package 日常练习.多线程.售票练习and线程安全.Lock锁;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    //票的数量
    private int ticket = 1000;
    private Object obj = new Object();
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                // synchronized (obj){
                if (ticket <= 0) {
                    //卖完了
                    break;
                } else {
                    Thread.sleep(10);
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticket + "张票");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            //}

        }
    }
}
