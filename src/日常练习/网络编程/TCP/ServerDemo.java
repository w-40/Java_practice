package 日常练习.网络编程.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        //1.创建Socket对象
        ServerSocket ss = new ServerSocket(10010);
        //2.等待客户端连接
        System.out.println("正在进行TCP连接");
        Socket accept = ss.accept();
        System.out.println("连接成功 正在接收数据...");
        //3.获得输入流对象
        InputStream is = accept.getInputStream();
        int b;
        while ((b = is.read()) != -1){
            System.out.print((char)b);
        }
        //4.释放资源
        is.close();
        ss.close();
    }
}
