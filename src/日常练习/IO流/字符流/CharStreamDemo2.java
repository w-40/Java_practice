package 日常练习.IO流.字符流;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {
        //method1();写一个字符
        //method2();写一个字符数组
        //method3();写出数组的一部分
        //method4();写一个字符串
        //method5();写一个字符串的一部分
    }

    private static void method5() throws IOException {//写一个字符串的一部分
        FileWriter fw = new FileWriter("E:\\桌面\\a.txt");
        String line = "王志凯";
        fw.write(line,0,2);
        fw.close();
    }

    private static void method4() throws IOException {//写一个字符串
        FileWriter fw = new FileWriter("E:\\桌面\\a.txt");
        String line = "王志凯";
        fw.write(line);
        fw.close();
    }

    private static void method3() throws IOException {   //写出数组的一部分
        FileWriter fw = new FileWriter("E:\\桌面\\a.txt");
        char[] chars = {97,98,99,100,101};
        fw.write(chars,0,3);
        fw.close();
    }

    private static void method2() throws IOException {   //写一个字符数组
        FileWriter fw = new FileWriter("E:\\桌面\\a.txt");
        char[] chars = {97,98,99,100,101};
        fw.write(chars);
        fw.close();
    }

    private static void method1() throws IOException {//写一个字符

        //创建字符输出流的对象
        //FileWriter fw = new FileWriter(new File(""));
        FileWriter fw = new FileWriter("E:\\桌面\\a.txt");
        //写出数据
        fw.write(97);
        fw.write(98);
        fw.write(99);
        //释放资源
        fw.close();
    }
}
