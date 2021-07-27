package 日常练习.多线程.线程池.volatile问题.synchronized解决;

public class Money {
    public static Object lock = new Object();
    public static volatile int money = 100000;
}
