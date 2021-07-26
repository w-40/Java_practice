package 日常练习.多线程.售票练习and线程安全.Runnable实现;

public class Ticket implements Runnable{
    //票的数量
    private int ticket = 1000;
    private Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj){
                if (ticket <= 0){
                    //卖完了
                    break;
                }else {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticket + "张票");
                }
            }

        }
    }
}
