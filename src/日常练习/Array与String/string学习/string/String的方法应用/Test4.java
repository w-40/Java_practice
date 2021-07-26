package 日常练习.Array与String.string学习.string.String的方法应用;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String s = sc.nextLine();
        int bigCount = 0;
        int smallCount = 0;
        int numCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c >= 'A'&&c <= 'Z'){
                bigCount++;
            }else if(c >= 'a'&&c <= 'z'){
                smallCount++;
            }else if(c >= '0'&&c <= '9'){
                numCount++;
            }
        }
        System.out.println("大写字母数："+bigCount);
        System.out.println("小写字母数："+smallCount);
        System.out.println("数字字符数："+numCount);
    }
}
