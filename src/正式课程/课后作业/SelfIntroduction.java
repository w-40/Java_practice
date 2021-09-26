package 正式课程.课后作业;

import java.util.Scanner;

enum Sex {
    男, 女
}

class Course {
    String name;
    Sex sex;
    String[] cou = new String[]{"C语言", "高数", "线代", "思修"};
    float[] score = new float[4];

    public void init() {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入你的名字");
        name = sc1.next();
        System.out.println("请输入你的性别（0代表男，1代表女）");
        byte flag = sc1.nextByte();
        if (flag == 0) {
            sex = Sex.男;
        } else {
            sex = Sex.女;
        }
        System.out.println("请输入C语言成绩");
        score[0] = sc1.nextInt();
        System.out.println("请输入高数成绩");
        score[1] = sc1.nextInt();
        System.out.println("请输入线代成绩");
        score[2] = sc1.nextInt();
        System.out.println("请输入思修成绩");
        score[3] = sc1.nextInt();
        sc1.close();
    }

    public void speak() {
        System.out.println("我的名字叫" + name + "," + sex + "," + "我上学期通过努力，取得了好成绩，各科成绩如下");
        for (int i = 0; i < score.length; i++) {
            System.out.println(cou[i] + "" + score[i] + "");
        }
    }
}

public class SelfIntroduction {
    public static void main(String[] args) {
        Course co = new Course();
        co.init();
        co.speak();
    }
}


