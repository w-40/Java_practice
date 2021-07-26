package 日常练习.Array与String.string学习.string.String的方法应用;

import 日常练习.Array与String.string学习.domain.Student;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生信息：");
        String stuInfo = sc.nextLine();
        String[] sArr = stuInfo.split(",");
//        System.out.println(sArr[0]);
//        System.out.println(sArr[1]);
        Student stu = new Student(sArr[0],sArr[1]);
        System.out.println(stu.getName() + "..." + stu.getAge());
    }
}
