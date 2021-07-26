package 日常练习.数据结构练习.Stream流;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MyStream4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("张翠山");
        list.add("王二麻子");
        list.add("张良");
        list.add("谢广坤");
        list.stream().forEach(s -> System.out.println(s));
        //原理
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        long count = list.stream().count();
        System.out.println(count);
    }
}
