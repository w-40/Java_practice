package 日常练习.多线程.线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo1 {
    public static void main(String[] args) throws InterruptedException {
        //1.创建一个默认的线程池对象，池子中默认是空的，默认最多可以容纳int类型的最大值
        ExecutorService executorService = Executors.newCachedThreadPool();
        //Excutors---可以帮助我们创建线程池对象
        //ExecutorService---可以帮助我们控制线程池

        executorService.submit( () -> {
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });

       // Thread.sleep(2000);

        executorService.submit( () ->{
            System.out.println(Thread.currentThread().getName() + "在执行了");
        });
        executorService.shutdown();
    }
}
