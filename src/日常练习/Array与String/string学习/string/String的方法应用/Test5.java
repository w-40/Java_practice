package 日常练习.Array与String.string学习.string.String的方法应用;

import java.util.Scanner;
//敏感词替换
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String s = sc.nextLine();
        String result = s.replace("TMD","***");
        System.out.println(result);
    }
}
