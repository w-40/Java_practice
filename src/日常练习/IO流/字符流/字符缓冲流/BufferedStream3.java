package 日常练习.IO流.字符流.字符缓冲流;
//特有方法--------newLine
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStream3 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\桌面\\a.txt"));
        bw.write("王志凯");
        bw.newLine();
        bw.write("abcde");
        bw.newLine();
        bw.write("-------------");
        bw.flush();
        bw.close();
    }
}
