package 日常练习.多线程.获取设置名字;

public class Demo {
    //1.线程是有默认名字的，格式为:Thread-编号
    public static void main(String[] args) {
        MyThread t1 = new MyThread("小蔡");
        MyThread t2 = new MyThread("小强");

       // t1.setName("小蔡");
       // t2.setName("小强");
        t1.start();
        t2.start();
    }
}
