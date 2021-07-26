package 日常练习.日期类.JDK8日期转换;

import java.time.LocalDateTime;

public class MyDateDemo6 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 12, 13, 14, 15);
        LocalDateTime newlocalDateTime1 = localDateTime.plusYears(1);
        System.out.println(newlocalDateTime1);
    }
}
