package 日常练习.网络编程.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1.创建一个Socket对象
        Socket socket = new Socket("127.0.0.1",10010);
        //2.获取一个IO流开始写数据
        OutputStream os = socket.getOutputStream();
        os.write("Hello".getBytes());
        //3.释放资源
        os.close();
        socket.close();
    }
}
