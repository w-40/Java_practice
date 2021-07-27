package 日常练习.网络编程.UDP;

import java.io.IOException;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1.找码头
        DatagramSocket ds = new DatagramSocket();
        //2.打包礼物
        String s = "送给王志凯的礼物";
        byte[] bytes = s.getBytes();//要发送的数据
        InetAddress address = InetAddress.getByName("127.0.0.1");//要发送的地址
        int port = 10000;//通过10000端口发送
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
        //3.由码头发送包裹
        ds.send(dp);
        //4.付钱走人
        ds.close();
    }
}
