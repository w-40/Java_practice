package 日常练习.Array与String.array学习.test;

import 日常练习.Array与String.array学习.domain.Student;

import java.util.ArrayList;

//集合存储字符串及遍历
public class Test1 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student stu1 = new Student("张三1",23);
        Student stu2 = new Student("张三2",23);
        Student stu3 = new Student("张三3",23);

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getName() + "..." +stu.getAge());
        }

    }
}
