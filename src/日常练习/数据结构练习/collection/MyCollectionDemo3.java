package 日常练习.数据结构练习.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//迭代器的使用1
public class MyCollectionDemo3 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        //1.获得迭代器对象
        //迭代器对象一旦被创建出来，默认指向集合的0索引处
        Iterator<String> it = list.iterator();
        //利用迭代器里面的方法进行遍历
        //当前位置是否有元素可以被取出
//        System.out.println(it.hasNext());
//        //取出当前位置的元素 + 将迭代器往后移动一个索引的位置
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
