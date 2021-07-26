package 日常练习.日期类.JDK8日期转换;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MyDateDemo3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 11, 11, 20);
        int year = localDateTime.getYear();
        System.out.println("年为" + year);
        int month = localDateTime.getMonthValue();
        System.out.println("月份为" + month);
        int day = localDateTime.getDayOfMonth();
        System.out.println("日期为" + day);
        int dayOfYear = localDateTime.getDayOfYear();
        System.out.println("这是一年中第" + dayOfYear + "天");
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println("星期为" + dayOfWeek);
        int minute = localDateTime.getMinute();
        System.out.println("分钟为" + minute);
        int hour = localDateTime.getHour();
        System.out.println("小时为" + hour);
    }
}
