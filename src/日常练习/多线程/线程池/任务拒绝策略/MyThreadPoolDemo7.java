package 日常练习.多线程.线程池.任务拒绝策略;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//任务拒绝策略--CallerRunsPolicy()--调用任务的run()方法绕过线程池直接执行
public class MyThreadPoolDemo7 {
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
                1,
                2,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0;i <= 10; i++){
            int y = i;
            pool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "---" + y);
            });
        }

        pool.shutdown();
    }
}
