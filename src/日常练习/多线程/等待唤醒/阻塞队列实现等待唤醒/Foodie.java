package 日常练习.多线程.等待唤醒.阻塞队列实现等待唤醒;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{
    private ArrayBlockingQueue<String> list;

    public Foodie(ArrayBlockingQueue<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String take = list.take();
                System.out.println("吃货从队列中获取了" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
