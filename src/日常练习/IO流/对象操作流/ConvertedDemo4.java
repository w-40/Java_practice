package 日常练习.IO流.对象操作流;
//学生对象封装到集合
import java.io.*;
import java.util.ArrayList;

public class ConvertedDemo4 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("张三",16);
        Student s2 = new Student("李四",22);
        Student s3 = new Student("王五",24);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        ArrayList list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        oos.writeObject(list);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        ArrayList<Student> list2 = (ArrayList<Student>) ois.readObject();
        for (Student student : list2) {
            System.out.println(student);
        }

        ois.close();
    }
}

