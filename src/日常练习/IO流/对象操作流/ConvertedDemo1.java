package 日常练习.IO流.对象操作流;

import java.io.*;
//如果想要这个类的对象能被序列化，那么这个类必须要实现一个接口Serializable
//称之为是一个标记性接口，里面没有任何的抽象方法
//只要一个类实现了这个Serializable接口，那么久表示这个类的对象可以被序列化.
public class ConvertedDemo1 {
    public static void main(String[] args) throws IOException {
        User user = new User("张三","2001");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        oos.writeObject(user);
        oos.close();
    }
}
