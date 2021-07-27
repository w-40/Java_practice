package 日常练习.多线程.并发工具类;

//Hashtable是线程安全的，但是会将整张表锁起来，效率低下
import java.util.Hashtable;

public class MyHashtableDemo {
    public static void main(String[] args) {
        Hashtable<String,String> hm = new Hashtable<>();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                hm.put(i + "",i + "");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 51; i++) {
                hm.put(i + "",i + "");
            }
        });
        t1.start();
        t2.start();
        System.out.println("----------------");
        //为了t1和t2能把数据全部添加完毕
        for (int i = 0; i < 51; i++) {
            System.out.println(hm.get(i + ""));
        }
    }
}
