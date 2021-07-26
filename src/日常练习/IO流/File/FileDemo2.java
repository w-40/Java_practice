package 日常练习.IO流.File;
//文件以及文件夹的创建以及删除
import java.io.File;
import java.io.IOException;

public class FileDemo2 {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();
        //method3();
        //method4();
        File file = new File("E:\\桌面\\FileTest");
        boolean result = file.delete();
        System.out.println(result);
    }

    private static void method4() {
        //1.删除不走回收站，直接从硬盘删掉
        //2.如果删除的是文件，那么直接删除，如果删除的是文件夹，那么只能删除空文件夹
        //3.如果要删除一个有内容的文件夹，只能先进入到这个文件夹，把里面的内容删除完毕，才能删除这个文件夹
        //简单来说：只能删除文件和空文件夹
        File file = new File("E:\\桌面\\FileTest\\b.txt");
        boolean result = file.delete();
        System.out.println(result);
    }

    private static void method3() {
        /*注意点
        * 1.可以创建单级文件夹，也可以创建多级文件夹
        * 2.不管调用者有没有后缀名，只能创建文件夹
        * */
        File file = new File("E:\\桌面\\FileTest\\aaa\\bbb\\ccc\\ddd");
        boolean result = file.mkdirs();
        System.out.println(result);
    }

    private static void method2() {
        /*注意点:
        * 1.只能创建单级文件夹，不能创建多级文件夹
        * 2.不管调用者有没有后缀名，只能创建单级文件夹
        * */
        File file = new File("E:\\桌面\\FileTest\\aaa");
        boolean result = file.mkdir();
        System.out.println(result);
    }

    private static void method1() throws IOException {
        /*注意点
        * 1.如果文件存在，那么创建失败，返回false
        * 2.如果文件不存在，那么创建成功，返回true
        * 3.createNewFile方法不管调用者有没有后缀名，只能创建文件
        * */
        File file1 = new File("E:\\桌面\\FileTest\\b.txt");
        boolean result1 = file1.createNewFile();
        System.out.println(result1);
    }
}
