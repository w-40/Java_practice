package 正式课程.week1.exp2;
/*
 * 判断闰年
 * */
import java.util.Scanner;

public class JudgeYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sc.nextInt();
        Year y = new Year(year);
        y.judge();
    }
}
class Year {
    int year;

    public Year(int year) {
        this.year = year;
    }

    public void judge(){
        if ((year % 400 != 0 && year % 4 == 0) || (year %400 == 0)){
            System.out.println("该年份是闰年");
        }else {
            System.out.println("该年份不是闰年");
        }
    }
}
