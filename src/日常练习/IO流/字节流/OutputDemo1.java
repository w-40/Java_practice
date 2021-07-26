package 日常练习.IO流.字节流;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputDemo1 {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();
        FileOutputStream fos = new FileOutputStream("E:\\桌面\\a.txt");
        byte[] bys = {97,98,99,100,102,105};
        fos.write(bys,1,3);
        fos.close();
    }

    private static void method2() throws IOException {
        FileOutputStream fos = new FileOutputStream("E:\\桌面\\a.txt");
        byte[] bys = {97,98,99};
        fos.write(bys);
        fos.close();
    }

    private static void method1() throws IOException {
        //1.创建字节输出流的对象---告诉虚拟机要往哪个文件中写数据了
        //注意：如果文件不存在，会帮我们自动创建出来
        //如果文件存在，会把文件清空
        FileOutputStream fos = new FileOutputStream("E:\\桌面\\a.txt");
        //2.写数据   传递一个整数时，那么实际写到文件中的，是这个整数在码表中对应的那个字符
        fos.write(97);
        //3.释放资源---每次使用完流必须释放资源
        fos.close();//告诉操作系统，我现在已经不要再用这个文件了.
    }
}
