package 日常练习.网络编程.UDP.组播;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientDemo {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket();

        String s = "Hello 组播";
        byte[] bytes = s.getBytes();//要发送的数据
        InetAddress address = InetAddress.getByName("224.0.1.0");//要发送的地址
        int port = 10000;//通过10000端口发送
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        ds.send(dp);

        ds.close();
    }
}
