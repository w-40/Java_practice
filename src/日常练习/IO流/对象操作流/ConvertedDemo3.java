package 日常练习.IO流.对象操作流;

import java.io.*;

public class ConvertedDemo3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("张三",16);
        Student s2 = new Student("李四",22);
        Student s3 = new Student("王五",24);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        Object obj;
        while (true){
            try {
                Object o = ois.readObject();
                System.out.println(o);
            }catch (EOFException e){
                break;
            }
        }
        ois.close();
    }
}
