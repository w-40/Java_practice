package 日常练习.数据结构练习.List练习;

import java.util.LinkedList;

public class MyLinkedListDemo4 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        //method1(list);
        //method2(list);
        //method3(list);
        String first = list.removeFirst();
        System.out.println(first);
        String last = list.removeLast();
        System.out.println(last);
        System.out.println(list);
    }

    private static void method3(LinkedList<String> list) {
        String first = list.getFirst();
        String last = list.getLast();
        System.out.println(first);
        System.out.println(last);
    }

    private static void method2(LinkedList<String> list) {
        //在该列表结尾插入指定的元素
        list.addLast("www");
        System.out.println(list);
    }

    private static void method1(LinkedList<String> list) {
        //在该列表开头插入指定的元素
        list.addFirst("qqq");
        System.out.println(list);
    }
}
