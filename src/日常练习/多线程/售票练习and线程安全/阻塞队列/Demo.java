package 日常练习.多线程.售票练习and线程安全.阻塞队列;

import java.util.concurrent.ArrayBlockingQueue;

//阻塞队列的基本用法
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        //创建阻塞队列的对象，容量为1
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        //存储元素
        arrayBlockingQueue.put("汉堡包");
        //取元素
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());

        System.out.println("程序结束");
    }
}
