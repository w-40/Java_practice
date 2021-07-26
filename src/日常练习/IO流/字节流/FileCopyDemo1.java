package 日常练习.IO流.字节流;
//复制文件
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyDemo1 {
    public static void main(String[] args) throws IOException {
        //创建了字节输入流，准备读数据
        FileInputStream fis = new FileInputStream("E:\\桌面\\a.avi");
        //创建了字节输出流，准备写数据
        FileOutputStream fos = new FileOutputStream("a,avi");
        int b = 0;
        while ((b = fis.read())!=-1){
            fos.write(b);
        }
        fis.close();
        fos.close();
    }
}
