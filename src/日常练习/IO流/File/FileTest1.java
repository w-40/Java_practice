package 日常练习.IO流.File;

import java.io.File;

//删除一个多级文件夹
public class FileTest1 {
    public static void main(String[] args) {
        File src = new File("E:\\桌面\\src");
        deleteDir(src);
    }

    private static void deleteDir(File src) {
        //先删掉这个文件夹中的所有内容
        //递归：方法在方法体中自己调用自己
        //可以解决所有文件夹和递归结合的题目
        //1.进入---------得到src文件夹里面所有内容的file对象
        File[] files = src.listFiles();
        //2.遍历
        for (File file : files) {
            if (file.isFile()){
                //3.判断--如果遍历得到的file对象是一个文件，那么直接删除
                file.delete();
            }else{
                //4.判断
                //递归
                deleteDir(file);       //参数一定要是src文件夹里面的file对象
            }
        }

        //最后删除这个文件夹
        src.delete();
    }
}
