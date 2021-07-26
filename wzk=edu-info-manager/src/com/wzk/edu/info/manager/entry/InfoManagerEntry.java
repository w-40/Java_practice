package com.wzk.edu.info.manager.entry;

import com.wzk.edu.info.manager.controller.OtherStudentController;
import com.wzk.edu.info.manager.controller.StudentController;
import com.wzk.edu.info.manager.controller.TeacherController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--------欢迎来到信息管理系统--------");
            System.out.println("请输入您的选择；1.学生管理  2.老师管理  3.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    //System.out.println("学生管理");
                    OtherStudentController studentcontroller = new OtherStudentController();
                    studentcontroller.start();
                    break;
                case "2":
                    //System.out.println("老师管理");
                    TeacherController teachercontroller = new TeacherController();
                    teachercontroller.start();
                    break;
                case "3":
                    System.out.println("感谢您的使用");
                    //跳出当前正在运行的JVM虚拟机
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入");
            }

        }

    }
}
