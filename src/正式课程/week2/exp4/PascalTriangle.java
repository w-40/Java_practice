package 正式课程.week2.exp4;

import java.util.Scanner;

/*
 * 数组实现杨辉三角
 * */
public class PascalTriangle {
    public static void main(String[] args) {
        System.out.print("请输入杨辉三角的行数：");
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int num[][] = new int[count][count];
        for (int loop = 0; loop < count; loop++) {
            num[loop][0] = 1;
        }
        for (int row = 1; row < count; row++) {
            for (int column = 1; column <= row; column++) {
                num[row][column] = num[row - 1][column] + num[row - 1][column - 1];
            }
        }
        for (int row = 0; row < count; row++) {
            for (int i = 0; i < 2 * (count - row) - 1; i++) {
                System.out.print(" ");
            }
            for (int column = 0; column <= row; column++) {
                // 输出控制，完美等腰
                System.out.printf("%-4d", num[row][column]);
            }
            System.out.println();
        }
        sc.close();
    }
}
