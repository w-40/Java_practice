package 日常练习.数据结构练习.Map练习;
//三种方式打印学生信息
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyMap4 {
    public static void main(String[] args) {
        HashMap<Student,String> hm = new HashMap<>();

        Student s1 = new Student("xiaohei",23);
        Student s2 = new Student("dapang",22);
        Student s3 = new Student("xiaomei",22);
        hm.put(s1,"天津");
        hm.put(s2,"上海");
        hm.put(s3,"北京");
        //三种方法遍历
        Set<Student> keys = hm.keySet();
        for (Student key : keys) {
            String value = hm.get(key);
            System.out.println(key + "-------" + value);
        }
        System.out.println("================");
        Set<Map.Entry<Student,String>>entries = hm.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            Student key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-------" + value);
        }
        System.out.println("================");
        hm.forEach(
                (Student key,String value) -> {
                    System.out.println(key + "-------" + value);
                }
        );
    }
}
