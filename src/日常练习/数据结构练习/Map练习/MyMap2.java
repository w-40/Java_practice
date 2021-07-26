package 日常练习.数据结构练习.Map练习;

import java.util.HashMap;
import java.util.Map;

public class MyMap2 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("0001","小智");
        map.put("0002","小美");
        map.put("0003","小胖");
        map.put("0004","小黑");
        map.put("0005","大师");

        //method1(map);
        //method2(map);
        //method3(map);
        //method4(map);
        //method5(map);
        //method6(map);
        int sizs = map.size();
        System.out.println(sizs);
    }

    private static void method6(Map<String, String> map) {
        boolean empty1 = map.isEmpty();
        System.out.println(empty1);

        map.clear();
        boolean empty2 = map.isEmpty();
        System.out.println(empty2);
    }

    private static void method5(Map<String, String> map) {
        boolean result1 = map.containsValue("aaa");
        boolean result2 = map.containsValue("小智");
        System.out.println(result1);
        System.out.println(result2);
    }

    private static void method4(Map<String, String> map) {
        boolean s = map.containsKey("0001");
        boolean v = map.containsKey("0006");
        System.out.println(s);
        System.out.println(v);
    }

    private static void method3(Map<String, String> map) {
        map.clear();
        System.out.println(map);
    }

    private static void method2(Map<String, String> map) {
        String s = map.remove("0001");
        System.out.println(s);
        System.out.println(map);
    }

    private static void method1(Map<String, String> map) {
        //put 添加元素
        //如果要添加的键不存在，那么会把键值对都添加到集合中
        //如果要添加的键是存在的，那么会覆盖原先的值，把原先值当做返回值进行返回
        String s= map.put("0001","aaa");
        System.out.println(s);
        System.out.println(map);
    }
}
