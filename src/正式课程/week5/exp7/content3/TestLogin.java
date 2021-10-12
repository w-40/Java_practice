package 正式课程.week5.exp7.content3;

import java.util.Scanner;

public class TestLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("------登录------");
            System.out.println("1 开发人员");
            System.out.println("2 管理人员");
            System.out.println("3 客户");
            System.out.println("请输入您的身份:");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    Person d = new Developer();
                    d.login();
                    break;
                case "2":
                    Person m = new Manager();
                    m.login();
                    break;
                case "3":
                    Person c = new Customer();
                    c.login();
                    break;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
}
