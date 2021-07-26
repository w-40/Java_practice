package 日常练习.日期类.秒杀;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyDate {
    public static void main(String[] args) throws ParseException {
        String start = "2020年11月11日00:00:00";
        String end = "2020年11月11日00:10:00";

        String 王志凯 = "2020年11月11日00:03:47";
        String 韩思远 = "2020年11月11日00:10:11";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        long starttime = sdf.parse(start).getTime();
        long endtime = sdf.parse(end).getTime();

//        System.out.println(starttime);
//        System.out.println(endtime);

        long 王志凯time = sdf.parse(王志凯).getTime();
        long 韩思远time = sdf.parse(韩思远).getTime();

        if(王志凯time >= starttime && 王志凯time <= endtime){
            System.out.println("王志凯参加上了秒杀活动");
        }else {
            System.out.println("王志凯没有参加上秒杀活动");
        }
        if(韩思远time >= starttime && 韩思远time <= endtime){
            System.out.println("韩思远参加上了秒杀活动");
        }else {
            System.out.println("韩思远没有参加上秒杀活动");
        }
    }
}
