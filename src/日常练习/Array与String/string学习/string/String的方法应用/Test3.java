package 日常练习.Array与String.string学习.string.String的方法应用;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String s = sc.nextLine();
        char [] chars = s.toCharArray();
        for(int i = 0;i < chars.length; i++){
            System.out.println(chars[i]);
        }
    }
}
