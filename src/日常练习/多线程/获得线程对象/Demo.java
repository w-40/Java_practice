package 日常练习.多线程.获得线程对象;
//currentThread()返回当前正在执行的线程对象的引用
public class Demo {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();//主线程
        System.out.println(name);
    }
}
