package 日常练习.IO流.字节流.字节缓冲流;

import java.io.*;

//缓冲流结合数组，进行文件拷贝
public class BufferedStream2 {
    public static void main(String[] args) throws IOException {
        //创建一个字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\桌面\\a.txt"));
        //创建一个字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a.txt"));

        byte[] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
    }
}
