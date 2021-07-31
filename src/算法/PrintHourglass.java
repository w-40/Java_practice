package 算法;

import java.util.Scanner;

public class PrintHourglass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String x = sc.next();
        double t = Math.sqrt((N+1)*1.0/2);
        int n = (int)t;
        for (int i = n; i > 0; i--){
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print(x);
            }
            System.out.println();
        }
        int sum = N - (2 * n * n - 1);
        System.out.println(sum);
    }
}
//1. 首先我们要计算出最外层字符数和整个沙漏的总字符数；
//2. 对沙漏上一部分，从第二层开始，沙漏每增加一层，
//   根据其每层字符总数的变化：a1=3，a2=5，a3=7，a4=…易得公式等差数列an=2n+1；
//3. 等差数列的前n项和公式：Sn=(a1+an)(n/2)，联立an得出Sn=n(n+2);
//4. 算上第一层，则n层沙漏的总字符数为2S(n-1)+1=2n^2-1；
//5. 根据总字符数求出剩余字符数，在根据层数n输出沙漏。