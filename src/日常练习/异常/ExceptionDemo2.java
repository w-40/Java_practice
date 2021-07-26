package 日常练习.异常;

import java.util.Scanner;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的年龄");
            String line = sc.nextLine();
            int age = Integer.parseInt(line);
            System.out.println(age);
            System.out.println(2/0);
            System.out.println("测试123");
        } catch (NumberFormatException e) {
            System.out.println("格式化异常出现了");
        }catch(ArithmeticException e ){
            System.out.println("数学运算异常出现了");
        }
        System.out.println("测试456");
    }
}
