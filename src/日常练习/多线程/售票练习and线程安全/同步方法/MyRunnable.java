package 日常练习.多线程.售票练习and线程安全.同步方法;

public class MyRunnable implements Runnable{
    private static int ticketCount = 100;
    @Override
    public void run() {
        while (true){
            if ("窗口一".equals(Thread.currentThread().getName())){
                //同步方法
                boolean result = synchronizedMthod();
                if (result){
                    break;
                }
            }
            if ("窗口二".equals(Thread.currentThread().getName())){
                //同步代码块
                synchronized (this){
                    if(ticketCount == 0){
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

    private static synchronized boolean synchronizedMthod() {
        if(ticketCount == 0){
            return true;
        }else {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + "在卖票，还剩下" + ticketCount + "张票");
            return false;
        }
    }
}
