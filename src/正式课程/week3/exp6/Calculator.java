package 正式课程.week3.exp6;

import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);

    private int num1, num2;
    private char op;

    public Calculator() {
        System.out.println("请输入要计算的表达式");
        num1 = sc.nextInt();
        op = sc.next().charAt(0);
        num2 = sc.nextInt();
    }

    public Calculator(int num1, int num2, char op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public float cal() {
        float result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("没有您想要的功能");
                break;
        }
        return result;
    }
}