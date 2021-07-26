package 日常练习.多线程.售票练习and线程安全.Runnable实现;

public class Demo {
    public static void main(String[] args) {
        //三个线程用一个参数，所以只创建一个
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
       
        t1.start();
        t2.start();
        t3.start();
    }
}
