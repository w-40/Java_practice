package 正式课程.week1.exp2;
/*
* 水仙花数
* */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个位数大于等于三位的数字:");
        int n = sc.nextInt();
        Number number = new Number(n);
        number.judge();

    }
}

class Number {
    private int num;
    boolean flag = true;

    public Number(int num) {
        this.num = num;
    }

    public void judge() {
        int count = 0;  //记录该数字的位数
        int sum = num;

        //计算该数字的位数
        while (true) {
            count++;
            sum /= 10;
            if (sum == 0) {
                break;
            }
        }
        //判断每位数字的次方和
        for (int i = 1, j = 1; j <= count; i *= 10, j++) {
            sum += Math.pow(num/i%10,count);
        }
        if (sum != num){
            flag = false;
        }
        if (flag){
            System.out.println("该数字是水仙花数");
        }else {
            System.out.println("该数字不是水仙花数");
        }
    }
}
