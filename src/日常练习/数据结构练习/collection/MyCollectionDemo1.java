package 日常练习.数据结构练习.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class MyCollectionDemo1 {
    public static void main(String[] args) {
        //数组可以存储基本数据类型，也可以存储引用数据类型
        int[] arr1 = {1,2,3};
        String[] arr2 = {"a","b","c"};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");

        System.out.println(list1);

        //如果集合要存储基本数据类型，那么实际存储的是他们的包装类
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        System.out.println(list2);
    }
}
