package 日常练习.Array与String.string学习.string.String的方法应用;
//遍历字符串
import java.util.Scanner;

public class Tesr2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            System.out.println(c);
        }
    }
}
