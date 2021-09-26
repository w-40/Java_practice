package 正式课程.week3.exp5;

import java.util.Scanner;

public class Box {
    Scanner sc = new Scanner(System.in);
    private float length;
    private float width;
    private float height;

    // 构造方法（无参，从键盘接收数据）
    public Box() {
        System.out.println("请输入盒子的长、宽、高：");
        length = sc.nextFloat();
        width = sc.nextFloat();
        height = sc.nextFloat();
    }

    // 构造方法（构造正方体的盒子）
    public Box(float side) {
        length = side;
        width = side;
        height = side;
    }

    // 构造方法（用三个参数构造长方体的盒子）
    public Box(float length, float width, float height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public float getValue() {
        return length * width * height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
