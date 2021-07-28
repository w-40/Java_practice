package 日常练习.网络编程.TCP.练习1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10010);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1){
            System.out.print((char)b);
        }
        System.out.println();
        System.out.println("看看我执行了吗");
        /*OutputStream os = accept.getOutputStream();
        os.write("你谁啊".getBytes());*/
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("你谁啊");
        bw.newLine();
        bw.flush();

        bw.close();
        is.close();
        accept.close();
        ss.close();
    }
}
