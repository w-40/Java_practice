package 日常练习.数据结构练习.Set.HashSet;

import java.util.HashSet;

public class HashSetTest1 {
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();

        Student s1 = new Student("xiaohei",23);
        Student s2 = new Student("xiaohei",23);
        Student s3 = new Student("xiaomei",22);

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        System.out.println(hs);
    }
}
