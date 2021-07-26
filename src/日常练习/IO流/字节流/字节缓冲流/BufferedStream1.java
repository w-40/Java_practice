package 日常练习.IO流.字节流.字节缓冲流;
//利用缓冲流拷贝文件
import java.io.*;

public class BufferedStream1 {
    public static void main(String[] args) throws IOException {
        //创建一个字节缓冲输入流
        //在底层创建了一个默认长度为8192的字节数组
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\桌面\\a.txt"));
        //创建一个字节缓冲输出流
        //在底层也创建了一个默认长度为8192的字节数组
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("a.txt"));
        int b;
        while ((b = bis.read()) != -1){
            bos.write(b);
        }
        //方法的底层会把字节流关闭
        bis.close();
        bos.close();
    }
}
