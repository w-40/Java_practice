package 日常练习.数据结构练习.collection;

import java.util.ArrayList;
import java.util.Iterator;
//迭代器删除元素方法
public class MyCollectionDemo5 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String s= it.next();
            if("b".equals(s)){
                it.remove();
            }
        }
        System.out.println(list);
    }
}
