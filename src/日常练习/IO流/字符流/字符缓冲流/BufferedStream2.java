package 日常练习.IO流.字符流.字符缓冲流;
//输出
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStream2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\桌面\\a.txt"));
        bw.write(97);
        bw.write("\r\n");
        char[] chars = {97,98,99,100,101};
        bw.write(chars);
        bw.write("\r\n");
        bw.write(chars,0,3);
        bw.write("\r\n");
        bw.write("王志凯");
        bw.write("\r\n");
        String line = "abcdefg";
        bw.write(line,0,5);
        bw.flush();
        bw.close();
    }
}
