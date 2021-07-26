package 日常练习.IO流.字节流;
//读入数据（单字节和多字节）
import java.io.FileInputStream;
import java.io.IOException;

public class InputDemo1 {
    public static void main(String[] args) throws IOException {
        //method1();
        //如果文件存在，那么就不会报错
        //如果文件不存在，那么就会直接报错
        FileInputStream fis = new FileInputStream("E:\\桌面\\a.txt");
        int b;
        while((b = fis.read())!=-1){//读取不到文件内容时为-1
            System.out.println((char)b);
        }
        fis.close();


    }

    private static void method1() throws IOException {
        //如果文件存在，那么就不会报错
        //如果文件不存在，那么就会直接报错
        FileInputStream fis = new FileInputStream("E:\\桌面\\a.txt");

        int read = fis.read();
        //一次读取一个字节，返回值就是本次读到的那个字节数据
        //也就是字符在码表中对应的那个数字
        //如果我们想要看到的是字符数据，那么一定要强转成char
        System.out.println((char)read);
        //释放资源
        fis.close();
    }
}
