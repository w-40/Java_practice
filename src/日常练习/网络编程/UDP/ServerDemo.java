package 日常练习.网络编程.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerDemo {
    //注意点：
        //1.要先运行接收端，再运行发送端
        //2.如果接收端在启动之后，没有接收到数据，那么会死等（阻塞）
        //3.在接收数据的时候，需要调用一个getLength方法，表示接收到了多少字节
    public static void main(String[] args) throws IOException {
        //1.找码头 ---表示接收端从10000端口接收数据
        DatagramSocket ds = new DatagramSocket(10000);
        //2.创建一个新的箱子
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        //3.接收礼物，把礼物放到新箱子中
        System.out.println("-----接收前------");
        ds.receive(dp);
        System.out.println("-----接收后------");
        //4.从新的箱子里面获取礼物
        //byte[] data = dp.getData();
        int length = dp.getLength();
       // System.out.println(new String(data,0,length));
        System.out.println(new String(bytes,0,length));
        //5.拿完走人
        ds.close();
    }
}
