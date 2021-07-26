package 日常练习.数据结构练习.Stream流;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyStream5 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        //filter负责过滤数据
        //collect负责收集数据
        List<Integer> list = list1.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println(list);


        Set<Integer> set = list1.stream().filter(number -> number % 2 == 0).collect(Collectors.toSet());
        System.out.println(set);


    }
}
