package 日常练习.IO流.字符流;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharStreamDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //method1();
        byte[] bytes1 = {-25, -114, -117, -27, -65, -105, -27, -121, -81};
        byte[] bytes2 = {-51, -11, -42, -66, -65, -83};

        String s1 = new String(bytes1);
        System.out.println(s1);

        String s2 = new String(bytes2,"gbk");
        System.out.println(s2);
    }

    private static void method1() throws UnsupportedEncodingException {
        String s = "王志凯";
        //利用idea默认的UTF-8将中文编码为一系列的字节
        byte[] bytes1 = s.getBytes();
        System.out.println(Arrays.toString(bytes1));

        //byte[] bytes2 = s.getBytes("UTF-8");
        byte[] bytes2 = s.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));
    }
}
