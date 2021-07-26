package com.wzk.edu.info.manager.controller;

import com.wzk.edu.info.manager.domain.Student;
import com.wzk.edu.info.manager.service.StudentService;

import java.util.Scanner;

public abstract class BaseStudentController {

    private StudentService studentservice = new StudentService();

    //1.键盘接收学生信息
    private Scanner sc = new Scanner(System.in);

    //开启学生管理系统并展示菜单
    public final void start() {

        studentLoop:
        while (true) {
            System.out.println("--------欢迎来到<学生>信息管理系统--------");
            System.out.println("请输入您的选择；1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    //System.out.println("添加");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("删除");
                    deleteStudentById();
                    break;
                case "3":
                    // System.out.println("修改");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("查询");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统，再见！");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
            }

        }
    }

    public final void updateStudent() {
        String updateId = inputStudentId();

        Student newStu = inputStudentInfo(updateId);
        studentservice.updateStudent(updateId, newStu);
        System.out.println("修改成功");
    }

    public final void deleteStudentById() {
        String delId = inputStudentId();

        //3.调用Student
        studentservice.deleteStudentById(delId);
        //4.提示删除成功
        System.out.println("删除成功");
    }

    public final void findAllStudent() {
        //1.调用StudentService中的获取方法，得到学生的对象数组
        Student[] stus = studentservice.findAllStudent();
        //2.判断数组的内存地址是否为null
        if (stus == null) {
            System.out.println("查无信息，请添加后重试");
            return;
        }
        //3.遍历数组，获取学生信息并打印在控制台
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }

    public final void addStudent() {
        String id;
        while (true) {
            System.out.println("请输入学生ID：");
            id = sc.next();
            boolean flag = studentservice.isExists(id);
            if (flag) {
                System.out.println("学号已存在，请重新输入");
            } else {
                break;
            }
        }

        Student stu = inputStudentInfo(id);
        //3.将学生对象，传递给StudentService中的addStudent方法
        boolean result = studentservice.addStudent(stu);
        //4.根据返回的boolean方法，在控制台打印添加成功/失败
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //键盘录入学生id
    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("请输入学生的id");
            id = sc.next();
            //2.判断id在容器中是否存在，如果不存在，则需要一直录入
            boolean exists = studentservice.isExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在，请重新输入");
            } else {
                break;
            }
        }
        return id;
    }

    //开闭原则：对扩展内容开放，对修改内容关闭

    //键盘录入学生信息
    public abstract Student inputStudentInfo(String id);
}