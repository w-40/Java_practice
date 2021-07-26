package 日常练习.IO流.字符流.字符缓冲流;
//特有方法-------readLine
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStream4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\桌面\\a.txt"));
        String line1 = br.readLine();
        String line2 = br.readLine();
        String line3 = br.readLine();
        String line4 = br.readLine();
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line3);
        System.out.println(line4);
    }
}
