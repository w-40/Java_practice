package 日常练习.多线程.并发工具类;

//ConcurrentHashMap线程安全且效率较高
import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> hm = new ConcurrentHashMap<>();

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
