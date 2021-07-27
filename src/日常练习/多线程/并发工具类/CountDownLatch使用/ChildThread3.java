package 日常练习.多线程.并发工具类.CountDownLatch使用;


import java.util.concurrent.CountDownLatch;

public class ChildThread3 extends Thread {
    private CountDownLatch countDownLatch;
    public ChildThread3(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        //1.吃饺子
        for (int i = 0; i <= 20; i++) {
            System.out.println(getName() + "在吃第" + i + "个饺子");
        }
        //2.吃完说一声
        //每一次调用countDownLatch方法时，计数器减一
        countDownLatch.countDown();
    }
}
