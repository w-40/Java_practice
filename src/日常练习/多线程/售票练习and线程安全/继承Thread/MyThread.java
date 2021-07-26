package 日常练习.多线程.售票练习and线程安全.继承Thread;

public class MyThread extends Thread{
    private static int ticketCount = 500;
    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj){//当前的线程对象
                if (ticketCount <= 0){
                    //卖完了
                    break;
                }else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticketCount--;
                    System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticketCount + "张票");
                }
            }
        }
    }
}
