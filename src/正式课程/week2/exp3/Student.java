package 正式课程.week2.exp3;

import java.util.Scanner;

enum Sex {
    Man, Woman;
}

public class Student {
    private String name;
    private Sex sex;
    private String[] course ={"高数","线代","C语言","面向对象"};
    private float[] grade;

    Scanner sc = new Scanner(System.in);


    public void addStudent() {
        System.out.println("请输入学生姓名：");
        name = sc.next();
        System.out.println("请输入学生性别(0代表男，1代表女)：");
        byte flag = sc.nextByte();
        if (flag == 0) {
            sex = Sex.Man;
        } else {
            sex = Sex.Woman;
        }
        grade = new float[course.length];
        System.out.println("请输入学生四门课的成绩(高数，线代，C语言，面向对象)：");
        for (int i = 0; i < course.length; i++) {
            grade[i] = sc.nextFloat();
        }
        System.out.println("添加成功");
    }
    public void printStudent() {
        System.out.println("姓名" + name);
        System.out.println("性别" + sex);
        for (int i = 0; i < course.length; i++) {
            System.out.println(course[i] + ":" + grade[i] + ";");
        }
    }
    public void averageStudent() {
        float ave = 0, sum = 0;
        for (int i = 0; i < course.length; i++) {
            sum += grade[i];
        }
        ave = sum / course.length;
        System.out.println("平均成绩为：" + ave);
    }
}
