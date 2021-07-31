package 日常练习.网络编程.UDP.练习;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        while (true) {
            String s = sc.nextLine();
            if ("886".equals(s)){
                break;
            }
            byte[] bytes = s.getBytes();
            InetAddress address = InetAddress.getByName("192.168.1.102");
            int port = 10000;
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

            ds.send(dp);
        }
        ds.close();
    }
}
