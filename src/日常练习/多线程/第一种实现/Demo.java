package 日常练习.多线程.第一种实现;

public class Demo {
    public static void main(String[] args) {
        //创建一个线程对象
        MyThread t1 = new MyThread();
        //创建一个线程对象
        MyThread t2 = new MyThread();

        //run方法不会开启线程，start可以开启线程
        //开启第一条线程
        t1.start();
        //开启第二条线程
        t2.start();
    }
}
