package 日常练习.数据结构练习.Set.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<>();
        hs.add("Hello");
        hs.add("World");
        hs.add("Java");
        hs.add("Java");
        hs.add("Java");
        hs.add("Java");
        hs.add("Java");
        Iterator<String> it = hs.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("=============================");
        for (String h : hs) {
            System.out.println(h);
        }
    }
}
