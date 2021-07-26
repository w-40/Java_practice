package 日常练习.数据结构练习.collection;

import java.util.ArrayList;

public class MyCollectionDemo7 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

//        for (String str:list){
//            str = "q";
//        }
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list);
    }
}
