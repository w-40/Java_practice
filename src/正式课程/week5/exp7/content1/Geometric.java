package 正式课程.week5.exp7.content1;

import java.time.LocalDateTime;

public abstract class Geometric {
    protected String color;
    protected String filled;
    protected LocalDateTime date;

    public Geometric(String color, String filled, LocalDateTime date) {
        this.color = color;
        this.filled = filled;
        this.date = date;
    }

    @Override
    public String toString() {
        return "图形是：" +
                "颜色是：" + color +
                ", 填充情况为：" + filled +
                ", 创建时间为：" + date;
    }
}
