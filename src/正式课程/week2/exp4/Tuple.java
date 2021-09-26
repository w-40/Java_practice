package 正式课程.week2.exp4;

import java.util.Scanner;

public class Tuple {
    Scanner sc = new Scanner(System.in);
    float[] list;

    public void init() {
        System.out.println("请输入要创建的是几元组");
        int N = sc.nextInt();
        list = new float[N];
        System.out.println("请输入N个数来构造N元祖");
        for (int i = 0; i < N; i++) {
            list[i] = sc.nextFloat();
        }
    }


    public void getValue(int i) {
        System.out.println("N元祖的第" + i + "个元素的值为" + list[i - 1]);
    }

    public void updateValue(int i) {
        System.out.println("请输入修改后的值:");
        list[i] = sc.nextFloat();
        System.out.println("修改成功");
    }

    public void getMax() {
        float max = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        System.out.println("该N元祖的最大值为：" + max);
    }

    public void getMin() {
        float min = list[0];
        for (int i = 0; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
            }
        }
        System.out.println("该N元祖的最小值为：" + min);
    }

    public void show() {
        System.out.println("该N元祖为:");
        for (float l : list) {
            System.out.print(l + " ");
        }
        System.out.println();
    }
}
