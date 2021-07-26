package 日常练习.数据结构练习.collection;

import java.util.ArrayList;

public class MyCollectionDemo6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        //1.数据类型一定是集合或者数组中元素的类型
        //2.str仅仅是一个变量名而已，在循环的过程中，依次表示集合或者数组中的每一个元素
        //3.list就是要遍历的集合或者数组
        for (String str:list){
            System.out.println(str);
        }
    }
}
