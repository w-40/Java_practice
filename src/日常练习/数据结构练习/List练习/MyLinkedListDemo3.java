package 日常练习.数据结构练习.List练习;

import java.util.Iterator;
import java.util.LinkedList;

public class MyLinkedListDemo3 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("----------------");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
