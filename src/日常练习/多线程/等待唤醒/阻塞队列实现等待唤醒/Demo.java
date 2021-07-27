package 日常练习.多线程.等待唤醒.阻塞队列实现等待唤醒;

import java.util.concurrent.ArrayBlockingQueue;
//看到的输出语句是乱的是因为输出语句不在底层的锁里面，不影响正常结果
public class Demo {
    public static void main(String[] args) {
        //创建阻塞队列
        ArrayBlockingQueue<String> list = new ArrayBlockingQueue<>(1);
        //创建线程并开启
        Cooker c = new Cooker(list);
        Foodie f = new Foodie(list);

        c.start();
        f.start();
    }
}
