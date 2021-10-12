package 正式课程.week5.exp7.content1;

import java.time.LocalDateTime;

public class TestGeometric {
    public static void main(String[] args) {
        Circle c = new Circle("红色","填充", LocalDateTime.now(),5);
        System.out.println(c);
        Rectangle r = new Rectangle("绿色","填充",LocalDateTime.now(),5,6);
        System.out.println(r);
    }

}
