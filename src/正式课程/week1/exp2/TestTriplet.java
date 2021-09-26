package 正式课程.week1.exp2;
/*
 * 三元组
 * */

import java.util.Scanner;

public class TestTriplet {
    public static void main(String[] args) {
        Triplet t1 = new Triplet();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--------三元组实现--------");
            System.out.println("1 创建三元组");
            System.out.println("2 获取三元组的一个分量");
            System.out.println("3 修改三元组的一个分量");
            System.out.println("4 求三元组的最大分量");
            System.out.println("5 求三元组的最小分量");
            System.out.println("6 显示三元组");
            System.out.println("7 销毁三元组");
            System.out.println("8 退出");
            System.out.println("请输入您的选择");

            String choice = sc.next();

            lo:
            switch (choice) {
                case "1":
                    t1.init();
                    break;
                case "2":
                    System.out.println("请输入你要获取的三元组值的序号");
                    int i = sc.nextInt();
                    t1.getValue(i);
                    break;
                case "3":
                    System.out.println("请输入你要修改的三元组值的序号");
                    i = sc.nextInt();
                    t1.updateValue(i);
                    break;
                case "4":
                    System.out.println("三元组的最大值为：" + t1.getMax());
                    break;
                case "5":
                    System.out.println("三元组的最小值为：" + t1.getMin());
                    break;
                case "6":
                    t1.show();
                    break;
                case "7":
                    t1 = null;
                    System.out.println("销毁成功");
                    break;
                case "8":
                    System.out.println("感谢您的使用");
                    break lo;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
}