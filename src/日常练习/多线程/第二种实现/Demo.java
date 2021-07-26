package 日常练习.多线程.第二种实现;

public class Demo {
    public static void main(String[] args) {
        //创建了一个参数的对象
        MyRunnable mr = new MyRunnable();
        //创建了一个线程对象，并把参数传递给这个线程
        //在线程启动之后，执行的就是参数里面的run方法
        Thread t1 = new Thread(mr);
        MyRunnable mr2 = new MyRunnable();
        Thread t2 = new Thread(mr2);
        t1.start();
        t2.start();
    }
}
