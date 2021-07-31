package 算法;

import java.util.Scanner;

public class TotalDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int len = N.length();
        int[] x = new int[len];
        for (int i = 0; i < len; i++) {
            x[i] = N.charAt(i) - '0';
        }
        int[] s = new int[10];

        for (int i = 0; i < x.length; i++)
            s[x[i]]++;
        for (int j = 0; j < s.length; j++) {
            if (s[j] != 0) {
                System.out.println(j + ":" + s[j]);
            }
        }
    }
}