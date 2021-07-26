package 日常练习.日期类.JDK8日期转换;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyDateDemo1 {
    public static void main(String[] args) {
        String s = "2020年11月11日00:00:00";

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(s, pattern);
        //时间增加一天
        LocalDateTime newlocalDateTime = localDateTime.plusDays(1);
        String result = newlocalDateTime.format(pattern);
        System.out.println(result);
    }
}
