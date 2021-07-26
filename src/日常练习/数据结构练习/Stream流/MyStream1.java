package 日常练习.数据结构练习.Stream流;
/*
* Stream流的获取
* 单列集合：集合对象.stream();
* 双列集合：不能直接获取，需要间接获取
*       集合对象.keySet().stream();
*       集合对象.entrySet.stream();
* 数组   ：
*       Arrays.stream(数组名)；
* 同种数据类型的多个数据：
*       Stream.of(数据1,数据2,数据3......);
* */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Stream;

public class MyStream1 {
    public static void main(String[] args) {
        //单列集合
        //method1();

        //双列集合
        //method2();

        //数组
        //method3();

        //同种数据类型的多个数据
        //method4();
    }

    private static void method4() {
        Stream.of(1,2,3,4,5,6,7,8).forEach(s -> System.out.println(s));
    }

    private static void method3() {
        int[] arr ={1,2,3,4,5};
        Arrays.stream(arr).forEach(s -> System.out.println(s));
    }

    private static void method2() {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("zhangsan",23);
        hm.put("lisi",24);
        hm.put("wangwu",25);
        hm.put("zhaoliu",26);
        hm.put("qianqi",27);

        /*//双列集合不能直接获取Stream流
        //keySet
            //先获取到所有的键
            //再把这个Set集合中所有的键都放到Stream流中
        hm.keySet().stream().forEach(s -> System.out.println(s));*/
        //entrySet
        //先获取到所有的键值对对象
        //再把这个Set集合中所有的键值对对象放到Stream流中
        hm.entrySet().stream().forEach(s -> System.out.println(s));
    }

    private static void method1() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

       /* Stream<String> stream = list.stream();
        stream.forEach(s -> System.out.println(s));*/
        list.stream().forEach(s -> System.out.println(s));
    }
}
