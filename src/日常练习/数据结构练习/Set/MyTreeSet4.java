package 日常练习.数据结构练习.Set;

import java.util.Comparator;
import java.util.TreeSet;

public class MyTreeSet4 {
    public static void main(String[] args) {
        TreeSet<Teacher> ts = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                //o1表示现在要存入的那个元素
                //o2表示已经存入到集合中的元素
                //主要条件
                int result = o1.getAge() - o2.getAge();
                //次数条件
                result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                return result;
            }
        });
        Teacher t1 = new Teacher("zhangsan",23);
        Teacher t2 = new Teacher("lisi",22);
        Teacher t3 = new Teacher("wangwu",24);
        Teacher t4 = new Teacher("zhaoliu",24);
        ts.add(t1);
        ts.add(t2);
        ts.add(t3);
        ts.add(t4);
        System.out.println(ts);

    }
}
