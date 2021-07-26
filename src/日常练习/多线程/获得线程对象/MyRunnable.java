package 日常练习.多线程.获得线程对象;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {//currentThread()返回当前正在执行的线程对象的引用
            System.out.println(Thread.currentThread().getName() + "第二种方法实现多线程" + i);
        }
    }
}
