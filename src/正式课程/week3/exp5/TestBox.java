package 正式课程.week3.exp5;

import java.util.Scanner;

public class TestBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.长方体");
            System.out.println("2.正方体");
            System.out.println("请输入要计算体积的盒子类型:");
            int flag = sc.nextInt();
            switch (flag) {
                case 1:
                    System.out.println("请输入长方体盒子的长、宽、高：");
                    float length = sc.nextFloat();
                    float width = sc.nextFloat();
                    float height = sc.nextFloat();
                    Box box = new Box(length, width, height);
                    System.out.println("长为" + box.getLength()+ "，宽为" + box.getWidth() + "，高为" + box.getHeight() + "的体积为：" + box.getValue());
                    break;
                case 2:
                    System.out.println("请输入正方体盒子的边长：");
                    float side = sc.nextFloat();
                    Box sbox = new Box(side);
                    System.out.println("边长为" + side + "的体积为：" + sbox.getValue());
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入！");
                    break;
            }
        }
    }
}
