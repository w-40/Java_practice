package 日常练习.数据结构练习.Map练习;
//map的两种遍历方法
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMap3 {
    public static void main(String[] args) {
        //创建集合并添加元素
        Map<String,String> map = new HashMap<>();
        map.put("1号丈夫","1号妻子");
        map.put("2号丈夫","2号妻子");
        map.put("3号丈夫","3号妻子");
        map.put("4号丈夫","4号妻子");
        map.put("5号丈夫","5号妻子");
        //TraverseMethod1(map);
        //首先要获取到所有的键值对对象
        //Set集合中装的是键值对对象（Entry对象）
        //而Entry里面装的是键和值
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---------" + value);
        }

    }

    private static void TraverseMethod1(Map<String, String> map) {
        Set<String> keys = map.keySet();//获取到所有的键
        for (String key : keys) {
            //通过每一个键获取到对应的值
            String value = map.get(key);
            System.out.println(key + "----------" + value);
        }
    }
}
