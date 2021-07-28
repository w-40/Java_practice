package 日常练习.网络编程.TCP.上传文件;

import java.util.UUID;

public class UUIDDemo {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString().replace("-","");
        System.out.println(s);
    }
}
