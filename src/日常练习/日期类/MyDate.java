package 日常练习.日期类;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

public class MyDate {

    public static void main(String[] args) {
        Date date = new Date();
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = sdf.format(date);
        System.out.println(result);
    }
}
