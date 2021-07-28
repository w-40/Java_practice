package 日常练习.网络编程.TCP.上传文件;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10011);

        while (true) {
            Socket accept = ss.accept();
            ThreadSocket ts = new ThreadSocket(accept);
            new Thread(ts).start();
        }
        //ss.close();

    }
}
