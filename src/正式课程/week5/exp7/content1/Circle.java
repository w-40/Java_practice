package 正式课程.week5.exp7.content1;

import java.time.LocalDateTime;

public class Circle extends Geometric {
    private float radius;

    public Circle(String color, String filled, LocalDateTime date, float radius) {
        super(color, filled, date);
        this.radius = radius;
    }

    public float getArea() {
        return (float) Math.PI * radius * radius;
    }

    public float getPerimeter() {
        return (float) Math.PI * radius * 2;
    }

    public float getDiameter() {
        return radius * 2;
    }

    @Override
    public String toString() {
        return "图形是圆," +
                "半径为：" + radius +
                ", 颜色是：" + color +
                ", 填充情况是：" + filled +
                ", 创建时间是：" + date;
    }
}
