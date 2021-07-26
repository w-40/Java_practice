package 日常练习.数据结构练习.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class MyCollectionDemo8 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student s1 = new Student("甲", 23);
        Student s2 = new Student("乙", 31);
        Student s3 = new Student("丙", 33);
        list.add(s1);
        list.add(s2);
        list.add(s3);

        //迭代器
        Iterator<Student> it = list.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            System.out.println(s);
        }
        System.out.println("--------------------------------");
        //增强for
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
