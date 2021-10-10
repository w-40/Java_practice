package 日常练习.网络编程.TCP.上传文件;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.138.56.142", 10015);
        //是本地的流，用来读取本地文件的
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\open\\openEuler-20.03-LTS-x86_64-dvd.iso"));
        //写到服务器--网络中的流
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        //给服务器一个结束标记，告诉服务器文件已经传输完毕
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        socket.close();
        bis.close();
    }
}
