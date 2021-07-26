package 日常练习.多线程.第一种实现;
//多线程第一个实现方法
public class MyThread extends Thread{
    @Override
    public void run() {
        //代码就是在线程开启之后执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println("线程开启了"+ i);
        }
    }
}
