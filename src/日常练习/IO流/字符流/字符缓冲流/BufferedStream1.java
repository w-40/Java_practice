package 日常练习.IO流.字符流.字符缓冲流;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//输入
public class BufferedStream1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\桌面\\a.txt"));
        char[] chars = new char[1024];
        int len;
        while ((len = br.read(chars)) != -1){
            System.out.println(new String(chars,0,len));
        }
        br.close();
    }
}
