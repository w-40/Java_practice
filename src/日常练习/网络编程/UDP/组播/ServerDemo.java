package 日常练习.网络编程.UDP.组播;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServerDemo {

    public static void main(String[] args) throws IOException {

        MulticastSocket ms = new MulticastSocket(10000);

        DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
        ms.joinGroup(InetAddress.getByName("224.0.1.0"));

        ms.receive(dp);
        byte[] data = dp.getData();
        int length = dp.getLength();

        System.out.println(new String(data,0,length));

        ms.close();
    }
}
