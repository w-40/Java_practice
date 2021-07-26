package 日常练习.IO流.字符流.字符缓冲流;
//练习----读取文件数据排序后重新写入文件
import java.io.*;
import java.util.Arrays;

public class BufferedStreamTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:\\桌面\\a.txt"));
        //输出流不能写在这里，因为会清空文件内容
        //BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\桌面\\a.txt"));（不能有）
        String line = br.readLine();
        System.out.println("读取到的字符串数据为" + line);
        br.close();
        String[] split = line.split(" ");//根据空格切割
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            String smallstr = split[i];
            int number = Integer.parseInt(smallstr);
            arr[i] = number;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\桌面\\a.txt"));
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i] + " ");
            bw.flush();
        }
        bw.close();
    }
}
