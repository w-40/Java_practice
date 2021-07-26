package 日常练习.IO流.字节流;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputDemo3 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream("E:\\桌面\\a.txt");
            fos.write(97);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //finally语句里面的代码一定会被执行
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
