package 正式课程.week1.exp2;

import java.util.Scanner;

public class Triplet {
    private float e1, e2, e3;
    Scanner sc = new Scanner(System.in);
    // 初始化三元组
    public void init() {

        System.out.println("请输入三个实数：");
        e1 = sc.nextFloat();
        e2 = sc.nextFloat();
        e3 = sc.nextFloat();
    }

    //获取最大数
    public float getMax() {
        float max = e1;
        if (e2 > max){
            max = e2;
        }
        if (e3 > max){
            max = e3;
        }
         return max;
    }
    //获取最小数
    public float getMin() {
        float min = e1;
        if (e2 < min){
            min = e2;
        }
        if (e3 < min){
            min = e3;
        }
        return min;
    }
    //获取三元组的一个分量
    public void getValue(int i) {
            switch (i) {
                case 1:
                    System.out.println("该元素的值为：" + e1);
                    break;
                case 2:
                    System.out.println("该元素的值为：" + e2);
                    break;
                case 3:
                    System.out.println("该元素的值为：" + e3);
                    break;
                default:
                    System.out.println("您的输入有误！");
                    break;
            }
    }
    //修改三元组的一个分量
    public void updateValue(int i) {
        switch (i) {
            case 1:
                System.out.println("请输入你要修改的值：");
                e1 = sc.nextFloat();
                break;
            case 2:
                System.out.println("请输入你要修改的值：");
                e2 = sc.nextFloat();
                break;
            case 3:
                System.out.println("请输入你要修改的值：");
                e3 = sc.nextFloat();
                break;
            default:
                System.out.println("您的输入有误！");
                break;
        }
    }
    public void show(){
        System.out.println("该三元组为："+ e1 + " " + e2 + " " + e3);
    }
}