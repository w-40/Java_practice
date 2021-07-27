package 日常练习.多线程.并发工具类.Semaphore用法;

import java.util.concurrent.Semaphore;

public class MyRunnable implements Runnable{
    private Semaphore semaphore = new Semaphore(2);
    //1.获得管理员对象
    @Override
    public void run() {
        //2.获得通行证
        try {
            semaphore.acquire();//发通行证
            //3.开始行驶
            System.out.println("获得了通行证开始行驶");
            Thread.sleep(2000);
            System.out.println("归还通行证");
            //4.归还通行证
            semaphore.release();//收回通行证
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
