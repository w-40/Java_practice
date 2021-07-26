package 日常练习.数据结构练习.Stream流;

import java.util.ArrayList;
import java.util.stream.Stream;

public class MyStream3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("张翠山");
        list.add("王二麻子");
        list.add("张良");
        list.add("谢广坤");
        list.add("谢广坤");
        list.add("谢广坤");

        /*截取指定参数的数据，此处为2
        list.stream().limit(2).forEach(s -> System.out.println(s));*/
        /*跳过指定参数的数据，此处为跳过前2个，保留后4个
        list.stream().skip(2).forEach(s -> System.out.println(s));*/
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("张三丰");
        list2.add("张无忌");
        list2.add("张翠山");
        list2.add("王二麻子");
        list2.add("张良");
        list2.add("谢广坤");
        //合并两个流
       /* Stream<String> stream = list.stream();
        Stream<String> stream2 = list2.stream();
        Stream<String> stream3 = Stream.concat(stream, stream2);
        stream3.forEach(s -> System.out.println(s));*/
       // Stream.concat(list.stream(),list2.stream()).forEach(s -> System.out.println(s));
        //去除流中重复元素（依赖hashCode和equals方法）
        //list.stream().distinct().forEach(s -> System.out.println(s));
    }
}

