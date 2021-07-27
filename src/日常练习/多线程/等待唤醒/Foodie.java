package 日常练习.多线程.等待唤醒;

public class Foodie extends Thread {
    @Override
    public void run() {
        //1.while(true)死循环
        //2.synchronized锁，锁对象要唯一
        //3.判断，共享数据是否结束，结束
        //4.判断，共享数据是否结束，没有结束
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0){
                    break;
                }else{
                    if (Desk.flag){
                        //有
                        System.out.println("吃货在吃汉堡包");
                        Desk.flag = false;
                        Desk.lock.notifyAll();
                        Desk.count--;
                    }else{
                        //没有就等待
                        //使用什么对象当作锁，那么就必须用这个对象去调用等待和唤醒的方法
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
