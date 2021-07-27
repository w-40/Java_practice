package 日常练习.多线程.并发工具类.CountDownLatch使用;
//使用场景：让某一条线程等待其他线程执行完毕之后再执行
import java.util.concurrent.CountDownLatch;

public class MyCountDownLatchDemo {
    public static void main(String[] args) {
        //1.创建CountDownLatch的对象，需要传递给四个线程
        //在底层就定义了一个计数器，此时计数器的值就是3
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //2.创建四个线程对象并开启他们
        MotherThread motherThread = new MotherThread(countDownLatch);
        motherThread.start();

        ChildThread1 t1 = new ChildThread1(countDownLatch);
        t1.setName("小明");
        ChildThread2 t2 = new ChildThread2(countDownLatch);
        t2.setName("小红");
        ChildThread3 t3 = new ChildThread3(countDownLatch);
        t3.setName("小刚");

        t1.start();
        t2.start();
        t3.start();
    }
}
