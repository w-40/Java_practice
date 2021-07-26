package 日常练习.数据结构练习.Set.treeSet练习;

import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();
        Student s1 = new Student("dahei",80,80,80);
        Student s2 = new Student("erhei",90,90,90);
        Student s3 = new Student("xiaohei",100,100,100);
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        for (Student student : ts) {
            System.out.println(student );
        }
    }
}
