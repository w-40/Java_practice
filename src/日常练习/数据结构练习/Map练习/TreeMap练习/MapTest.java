package 日常练习.数据结构练习.Map练习.TreeMap练习;



import java.util.Comparator;
import java.util.TreeMap;

public class MapTest {
    public static void main(String[] args) {
        TreeMap<Student, String> tm = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = o1.getAge() - o2.getAge();
                result = result == 0 ? o1.getName().compareTo(o2.getName()) :result;
                return result;
            }
        });
        Student s1 = new Student("小黑",18);
        Student s2 = new Student("大胖",20);
        Student s3 = new Student("小美",20);

        tm.put(s1,"山西");
        tm.put(s2,"北京");
        tm.put(s3,"上海");
        tm.forEach(
                (Student key, String value) -> {
                    System.out.println(key + "--------" + value);
                }
        );
    }
}
