package 日常练习.IO流.对象操作流;
//反序列化（序列化之后如果修改JavaBean类，要重新序列化，否则反序列化时会报错）
//也可以手动给出序列号（见User类）
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ConvertedDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"))) {
            User o = (User) ois.readObject();
            System.out.println(o);
            ois.close();
        }
    }
}
