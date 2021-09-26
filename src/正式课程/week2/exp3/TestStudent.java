package 正式课程.week2.exp3;

import java.util.Scanner;

public class TestStudent {

    Scanner sc = new Scanner(System.in);
    Student stu = new Student();

    public static void main(String[] args) {
        new TestStudent().menu();
    }

    public void menu() {
        while (true){
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 查看学生");
            System.out.println("3 计算平均成绩");
            System.out.println("4 退出");
            System.out.println("请输入您的选择");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    stu.addStudent();
                    break;
                case "2":
                    stu.printStudent();
                    break;
                case "3":
                    stu.averageStudent();
                    break;
                case "4":
                    System.out.println("感谢您的使用");
                    break;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
}
