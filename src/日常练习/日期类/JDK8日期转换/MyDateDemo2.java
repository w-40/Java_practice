package 日常练习.日期类.JDK8日期转换;

import java.time.LocalDateTime;

public class MyDateDemo2 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 00, 10, 12);
    }
}
