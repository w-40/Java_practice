package 日常练习.IO流.字符流.字符缓冲流;
//特有方法-------readLine（循环改进）
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStream5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\桌面\\a.txt"));
        String line;
        //读取一整行，读到回车换行符
        //但是不会读取到换行符
        while ((line = br.readLine()) !=null){
            System.out.println(line);
        }
        br.close();
    }
}
