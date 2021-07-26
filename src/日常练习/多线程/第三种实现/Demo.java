package 日常练习.多线程.第三种实现;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();

        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft);
        t1.start();
        //如果线程还没有结束，get会在这里死等
        String s = ft.get(); //获得线程运行结果
        System.out.println(s);
    }
}
