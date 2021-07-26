package 日常练习.Array与String.array学习.array;

import 日常练习.Array与String.array学习.domain.Student;

public class TestObjectArray {
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        Student stu1 = new Student("张三",23);
        Student stu2 = new Student("李四",24);
        Student stu3 = new Student("王五",25);
        arr[0] = stu1;
        arr[1] = stu2;
        arr[2] = stu3;
        for (int i = 0; i < arr.length; i++) {
            Student temp = arr[i];
            System.out.println(temp.getName() + "..." + temp.getAge());
        }
    }
}
