package 日常练习.IO流.File;
//File的构造方法
import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        //method1();
        //method2();        String与String拼接
        //method3();        File和String拼接
    }

    private static void method3() {
        File file1 = new File("E:\\桌面\\FileTest");
        String path = "a.txt";
        File file = new File(file1,path);
        System.out.println(file);
    }

    private static void method2() {
        String path1 = "E:\\桌面\\FileTest";
        String path2 = "a.txt";
        File file = new File(path1,path2);//把两个路径进行拼接
        System.out.println(file);//E:\桌面\FileTest\a.txt
    }

    private static void method1() {
        //通过将给定的路径名字符串转化为抽象路径名来创建新的file实例
        String path = "E:\\桌面\\FileTest\\a.txt";
        //把字符串表示形式的路径变成file对象就是为了使用file里面的方法
        File file = new File(path);
    }
}
