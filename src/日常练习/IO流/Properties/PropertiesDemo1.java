package 日常练习.IO流.Properties;
//集合---属于map集合
import java.util.Properties;
import java.util.Set;
import java.util.Map;

public class PropertiesDemo1 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //1.增
        prop.put("王志凯","123");
        prop.put("456","789");
        prop.put("789","123");
        System.out.println(prop);
        //2.删
       // prop.remove("456");
       // System.out.println(prop);
        //3.改
        prop.put("王志凯",456);
        System.out.println(prop);
        //4.查
    //    Object value = prop.get("王志凯");
    //    System.out.println(value);
        //遍历
        Set<Object> keys = prop.keySet();
        for (Object key : keys) {
            Object value = prop.get(key);
            System.out.println(key + "----" + value);
        }
        System.out.println("=======================");
        //装的是所有的键值对对象
        Set<Map.Entry<Object,Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "----" + value);
        }
    }
}
