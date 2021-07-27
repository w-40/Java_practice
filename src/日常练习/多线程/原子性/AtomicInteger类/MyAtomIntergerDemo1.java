package 日常练习.多线程.原子性.AtomicInteger类;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomIntergerDemo1 {
    public static void main(String[] args) {
        AtomicInteger ac = new AtomicInteger();//默认值为0
        System.out.println(ac);
        AtomicInteger ac2 = new AtomicInteger(10);//默认值为0
        System.out.println(ac2);
    }
}
