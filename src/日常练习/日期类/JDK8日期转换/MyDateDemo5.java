package 日常练习.日期类.JDK8日期转换;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateDemo5 {
    public static void main(String[] args) {
        //method1();
        //JDK8解析
        String s = "2020年11月12日13:14:15";
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, pattern);
        System.out.println(parse);
    }

    private static void method1() {
        //JDK8格式化
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 12, 13, 14, 15);
        System.out.println(localDateTime);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH:mm:ss");
        String s = localDateTime.format(pattern);
        System.out.println(s);
    }
}
