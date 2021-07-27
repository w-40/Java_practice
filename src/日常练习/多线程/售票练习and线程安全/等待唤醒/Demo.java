package 日常练习.多线程.售票练习and线程安全.等待唤醒;

public class Demo {
    public static void main(String[] args) {
        Foodie f = new Foodie();
        Cooker c= new Cooker();
        f.start();
        c.start();
    }
}
