package 日常练习.数据结构练习.List练习;

import java.util.ArrayList;
import java.util.List;

public class MyListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        //method1(list);
        //method2(list);
        //method3(list);
        String s = list.get(0);
        System.out.println(s);
    }

    private static void method3(List<String> list) {
        //被替换的那个元素，在集合中就不存在了
        String result = list.set(0,"qqq");
        System.out.println(result);
        System.out.println(list);
    }

    private static void method2(List<String> list) {
        //在list集合中有两个删除的方法
        //第一个 删除指定元素，返回值表示当前元素是否删除成功
        //第二个 删除指定索引的元素，返回值表示实际删除的元素
        String s = list.remove(0);
        System.out.println(s);
        System.out.println(list);
    }

    private static void method1(List<String> list) {
        list.add(0,"qqq");
        System.out.println(list);
    }
}
