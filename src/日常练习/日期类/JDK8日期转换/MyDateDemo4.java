package 日常练习.日期类.JDK8日期转换;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MyDateDemo4 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 12, 12, 8, 10, 20);
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println("日期为" + localDate);
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("时间为" + localTime);
    }
}
