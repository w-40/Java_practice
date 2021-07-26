package 日常练习.数据结构练习.Stream流;

import java.util.ArrayList;
import java.util.function.Predicate;

public class MyStream2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张无忌");
        list.add("张翠山");
        list.add("王二麻子");
        list.add("张良");
        list.add("谢广坤");
        //用filter方法获取流中的 每一个数据
        //而test方法中的s，就依次表示流中的每一个数据
        //我们只要在test方法中对s进行判断就可以了
        //如果判断的结果为true，则当前的数据留下
        //如果判断的结果为false，则当前数据就不要
/*        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                boolean result = s.startsWith("张");
                return result;
            }
        }).forEach(s -> System.out.println(s));*/
        //因为Predicate接口中只有一个抽象方法test
        //所以我们可以使用lambda表达式来简化
       /* list.stream().filter(
                (String s) -> {
                    boolean result = s.startsWith("张");
                    return result;
                }
        ).forEach(s -> System.out.println(s));*/
        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));
    }
}
