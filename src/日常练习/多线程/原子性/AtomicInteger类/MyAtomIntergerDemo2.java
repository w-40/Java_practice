package 日常练习.多线程.原子性.AtomicInteger类;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomIntergerDemo2 {
    public static void main(String[] args) {
        //method1();获取值
        //method2();以原子方式将当前值加1，并返回自增前的值
        //method3();以原子方式将当前值加1，并返回自增后的值
        //method4();以原子方式将参数与对象中的值相加，并返回结果
        //method5();以原子方式设置为newValue值相加，并返回旧值
    }

    private static void method5() {
        AtomicInteger ac5 = new AtomicInteger(10);
        int andSet = ac5.getAndSet(20);//以原子方式设置为newValue值相加，并返回旧值
        System.out.println(andSet);
        System.out.println(ac5.get());
    }

    private static void method4() {
        AtomicInteger ac4 = new AtomicInteger(10);
        int i = ac4.addAndGet(20);//以原子方式将参数与对象中的值相加，并返回结果
        System.out.println(i);
        System.out.println(ac4.get());
    }

    private static void method3() {
        AtomicInteger ac3 = new AtomicInteger(10);
        int i = ac3.incrementAndGet();//以原子方式将当前值加1，并返回自增后的值
        System.out.println(i);
        System.out.println(ac3.get());
    }

    private static void method2() {
        AtomicInteger ac2 = new AtomicInteger(10);
        int andIncrement = ac2.getAndIncrement();//以原子方式将当前值加1，并返回自增前的值
        System.out.println(andIncrement);
        System.out.println(ac2.get());
    }

    private static void method1() {
        AtomicInteger ac1 = new AtomicInteger(10);
        System.out.println(ac1.get());//获取值
    }
}
