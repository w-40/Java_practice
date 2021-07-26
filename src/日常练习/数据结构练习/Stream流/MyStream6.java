package 日常练习.数据结构练习.Stream流;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStream6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan,23");
        list.add("lisi,24");
        list.add("wangwu,25");

        Map<String,Integer> map = list.stream().filter(
                (String s) -> {
                    String[] split = s.split(",");
                    int age = Integer.parseInt(split[1]);
                    return age >= 24;
                }
        //collect方法只能获取到流中剩余的每一个数据.
        //在底层是不能创建容器，也不能把数据添加到容器当中

        // s 依次表示流中的每一个数据

        //第一个lambda表达式是如何获取到Map中的键
        //第一个lambda表达式是如何获取到Map中的值
        ).collect(Collectors.toMap(
                 s -> s.split(",")[0],
                 s -> Integer.parseInt(s.split(",")[1])));
        System.out.println(map);
    }
}
