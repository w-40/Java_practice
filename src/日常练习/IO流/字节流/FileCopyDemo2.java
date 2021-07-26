package 日常练习.IO流.字节流;

import java.io.*;

public class FileCopyDemo2 {
    public static void main(String[] args) throws IOException {
        //创建一个字节输入流
        FileInputStream fis = new FileInputStream("E:\\桌面\\a.txt");
        //创建一个字节输出流
        FileOutputStream fos = new FileOutputStream("a.txt");

        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
    }
}
