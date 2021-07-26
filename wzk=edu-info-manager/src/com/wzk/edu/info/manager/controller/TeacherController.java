package com.wzk.edu.info.manager.controller;

import com.wzk.edu.info.manager.domain.Teacher;
import com.wzk.edu.info.manager.service.StudentService;
import com.wzk.edu.info.manager.service.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherservice = new TeacherService();
    //1.键盘接收老师信息
    private Scanner sc = new Scanner(System.in);

    //开启老师管理系统并展示菜单
    public void start() {
        teacherLoop:
        while (true) {
            System.out.println("--------欢迎来到<老师>信息管理系统--------");
            System.out.println("请输入您的选择；1.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    //System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
                    //System.out.println("删除老师");
                    deleteTeacherById();
                    break;
                case "3":
                    // System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
                    //System.out.println("查询老师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您使用老师管理系统，再见！");
                    break teacherLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
            }

        }
    }

    public void updateTeacher() {
        String updateId = inputTeacherId();

        Teacher newTea = inputTeacherInfo(updateId);
        teacherservice.updateTeacher(updateId, newTea);
        System.out.println("修改成功");
    }

    public void deleteTeacherById() {
        String delId = inputTeacherId();

        //3.调用Teacher
        teacherservice.deleteTeacherById(delId);
        //4.提示删除成功
        System.out.println("删除成功");
    }

    public void findAllTeacher() {
        //1.调用TeacherService中的获取方法，得到老师的对象数组
        Teacher[] teas = teacherservice.findAllTeacher();
        //2.判断数组的内存地址是否为null
        if (teas == null) {
            System.out.println("查无信息，请添加后重试");
            return;
        }
        //3.遍历数组，获取老师信息并打印在控制台
        System.out.println("教工号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < teas.length; i++) {
            Teacher tea = teas[i];
            if (tea != null) {
                System.out.println(tea.getId() + "\t" + tea.getName() + "\t" + tea.getAge() + "\t\t" + tea.getBirthday());
            }
        }
    }

    public void addTeacher() {
        String id;
        while (true) {
            System.out.println("请输入老师ID：");
            id = sc.next();
            boolean flag = teacherservice.isExists(id);
            if (flag) {
                System.out.println("教工号已存在，请重新输入");
            } else {
                break;
            }
        }

        Teacher tea = inputTeacherInfo(id);
        //3.将学生对象，传递给TeacherService中的addTeacher方法
        boolean result = teacherservice.addTeacher(tea);
        //4.根据返回的boolean方法，在控制台打印添加成功/失败
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //键盘录入老师id
    public String inputTeacherId() {
        String id;
        while (true) {
            System.out.println("请输入老师的id");
            id = sc.next();
            //2.判断id在容器中是否存在，如果不存在，则需要一直录入
            boolean exists = teacherservice.isExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在，请重新输入");
            } else {
                break;
            }
        }
        return id;
    }

    //键盘录入老师信息
    public Teacher inputTeacherInfo(String id){
        System.out.println("请输入老师姓名：");
        String name = sc.next();
        System.out.println("请输入老师年龄：");
        String age = sc.next();
        System.out.println("请输入老师生日：");
        String birthday = sc.next();
        //2.将老师信息封装为老师对象
        Teacher tea = new Teacher();
        tea.setId(id);
        tea.setName(name);
        tea.setAge(age);
        tea.setBirthday(birthday);
        return tea;
    }
}
