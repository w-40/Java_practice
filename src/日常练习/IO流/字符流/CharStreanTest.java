package 日常练习.IO流.字符流;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreanTest {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        FileWriter fw = new FileWriter("E:\\桌面\\a.txt");
        fw.write(username);
        fw.write("\r\n");
        fw.write(password);
        fw.flush();
        fw.close();
    }

}
