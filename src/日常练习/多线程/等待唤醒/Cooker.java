package 日常练习.多线程.等待唤醒;



public class Cooker extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if(Desk.count == 0){
                    break;
                }else {
                    if (!Desk.flag){
                        //生产
                        System.out.println("厨师正在生产汉堡包");
                        Desk.flag = true;
                        Desk.lock.notifyAll();
                    }else {
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
