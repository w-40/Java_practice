package 日常练习.网络编程.Inetadress类;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IneaddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("DESKTOP-STHIJS8");

        String hostName = address.getHostName();
        System.out.println("主机名为" + hostName);

        String ip = address.getHostAddress();
        System.out.println("IP为" + ip);
    }
}
