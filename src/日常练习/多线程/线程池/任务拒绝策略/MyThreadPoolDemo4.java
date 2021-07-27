package 日常练习.多线程.线程池.任务拒绝策略;

import 日常练习.多线程.线程池.MyRunnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//任务拒绝策略--丢弃任务并抛出异常--默认策略
public class MyThreadPoolDemo4 {
    //参数一：核心线程数量
    //参数二：最大线程数
    //参数三：空闲线程最大存活时间
    //参数四：时间单位   --- Timeunit
    //参数五：任务队列   --- 让任务在队列中等着，等有线程空闲了，再从这个队列中获取任务并执行
    //参数六：创建线程工厂 ---按照默认的方式创建线程对象
    //参数七：任务的拒绝策略 ---①什么时候拒绝任务
                         //②如何拒绝
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0;i < 15; i++){
            pool.submit(new MyRunnable());
        }

        pool.shutdown();
    }
}
