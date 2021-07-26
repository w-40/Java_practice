package 日常练习.数据结构练习.List练习;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyListDemo1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();//多态
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("-------------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
