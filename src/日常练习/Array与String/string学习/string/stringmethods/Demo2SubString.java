package 日常练习.Array与String.string学习.string.stringmethods;

import java.util.Scanner;
//屏蔽手机号
public class Demo2SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入手机号：");
        String telString = sc.nextLine();
        //包含头，不包含尾
        String start = telString.substring(0,3);
        //从索引截取到末尾并返回
        String end = telString.substring(7);
        //要用字符串接收返回值，不然会丢失
        //拼接
        System.out.println(start+"****"+end);
    }
}
