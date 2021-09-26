package 正式课程.week2.exp4;
/*
 * N元组
 * */

import java.util.Scanner;

public class TestTuple {
    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("--------N元组实现--------");
            System.out.println("1 创建N元组");
            System.out.println("2 获取N元组的一个分量");
            System.out.println("3 修改N元组的一个分量");
            System.out.println("4 求N元组的最大分量");
            System.out.println("5 求N元组的最小分量");
            System.out.println("6 显示N元组");
            System.out.println("7 销毁N元组");
            System.out.println("8 退出");
            System.out.println("请输入您的选择");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    tuple.init();
                    break;
                case "2":
                    int i;
                    lo:
                    while (true) {
                        System.out.println("请输入你要获取的N元组值的序号:");
                        i = sc.nextInt();
                        if (i < tuple.list.length || i < 0) {
                            break lo;
                        } else {
                            System.out.println("您的输入有误,请重新输入！");
                        }
                    }
                    tuple.getValue(i);
                    break;
                case "3":
                    lo:
                    while (true) {
                        System.out.println("请输入你要修改的N元组值的序号:");
                        i = sc.nextInt();
                        if (i < tuple.list.length || i < 0) {
                            break lo;
                        } else {
                            System.out.println("您的输入有误,请重新输入！");
                        }
                    }
                    tuple.updateValue(i);
                    break;
                case "4":
                    tuple.getMax();
                    break;
                case "5":
                    tuple.getMin();
                    break;
                case "6":
                    tuple.show();
                    break;
                case "7":
                    tuple = null;
                    System.out.println("销毁成功");
                    break;
                case "8":
                    System.out.println("感谢您的使用");
                    System.exit(0);
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
}