package 日常练习.IO流.字节流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputDemo2 {
    public static void main(String[] args) throws IOException {
        //第二个参数就是续写开关，如果没有传递，默认是false，
        //表示不打开续写功能，那么创建对象的这行代码会清空文件

        //如果第二个参数为true，表示打开续写功能
        //那么创建对象的这行代码不会清空文件
        FileOutputStream fos = new FileOutputStream("E:\\桌面\\a.txt",true);
        fos.write(95);
        fos.write("\r\n".getBytes());
        fos.write(156);
        fos.write("\r\n".getBytes());
        fos.write(104);
        fos.write("\r\n".getBytes());
        fos.write(98);
        fos.write("\r\n".getBytes());
        fos.write(105);
        fos.write("\r\n".getBytes());
        fos.write(100);

        fos.close();
    }
}
