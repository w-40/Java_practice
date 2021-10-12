package 正式课程.week5.exp7.content1;

import java.time.LocalDateTime;

public class Rectangle extends Geometric {
    private float bottom;
    private float height;

    public Rectangle(String color, String filled, LocalDateTime date, float bottom, float height) {
        super(color, filled, date);
        this.bottom = bottom;
        this.height = height;
    }

    public float getArea() {
        return bottom * height;
    }

    public float getPerimeter() {
        return (bottom + height) * 2;
    }
    @Override
    public String toString() {
        return "图形是矩形," +
                "底为：" + bottom +
                "高为：" + height +
                ", 颜色是：" + color +
                ", 填充情况是：" + filled +
                ", 创建时间是：" + date;
    }
}
