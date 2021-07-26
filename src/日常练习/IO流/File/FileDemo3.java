package 日常练习.IO流.File;

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {
        File file = new File("D:\\");
        //进入文件夹，获取这个文件夹里面所有的文件和文件夹的file对象，并把这些file对象都放在一个数组中返回
        //包括隐藏文件和隐藏文件夹都可以获取

        //1.当调用者是一个文件夹时，会返回null
        //2.当调用者是一个空文件夹时，返回一个长度为0的数组
        //3.当调用者是一个有内容的文件夹时，返回一个数组
        //4.当调用者是一个有权限才能进入的文件夹时，返回null
        File[] files = file.listFiles();
        for (File path : files) {
            System.out.println(path);
        }
    }
}
