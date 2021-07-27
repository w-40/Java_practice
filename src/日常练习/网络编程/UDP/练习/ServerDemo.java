package 日常练习.网络编程.UDP.练习;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);

        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

            ds.receive(dp);
            byte[] data = dp.getData();
            int length = dp.getLength();

            System.out.println(new String(data,0,length));
        }

       // ds.close();
    }
}
