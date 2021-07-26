package 日常练习.IO流.字符流;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {
        //method1();一次读取一个字符
        FileReader fr = new FileReader("E:\\桌面\\a.txt");
        //创建一个数组
        char[] chars = new char[1024];
        int len;//表示本次读到了多少个字符
        while ((len = fr.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }
        fr.close();
    }

    private static void method1() throws IOException {
        FileReader fr = new FileReader("E:\\桌面\\a.txt");
        int ch;
        //一次读取一个字符
        while((ch = fr.read()) != -1){
            System.out.println((char)ch);
        }
        fr.close();
    }
}
