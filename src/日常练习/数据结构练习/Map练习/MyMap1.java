package 日常练习.数据结构练习.Map练习;

import java.util.HashMap;
import java.util.Map;

//Map基本使用
public class MyMap1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("0001","王志凯");
        map.put("0002","王");
        map.put("0003","志凯");
        System.out.println(map);
    }
}
