package 日常练习.Array与String.array学习.test;

import 日常练习.Array与String.array学习.domain.Student;

import java.util.ArrayList;

public class Test3 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("张三1",10);
        Student stu2 = new Student("张三2",10);
        Student stu3 = new Student("张三3",20);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        ArrayList<Student> newlist= getList(list);
        for (int i = 0; i < newlist.size(); i++) {
            Student student = newlist.get(i);
            System.out.println(student.getName() + "..." + student.getAge());
        }
        
    }
    public static ArrayList<Student> getList(ArrayList<Student> list){
        ArrayList<Student> newlist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            int age = stu.getAge();
            if(age<18){
                newlist.add(stu);
            }
        }
        return newlist;
    }
}
