package 日常练习.高级部分.类加载器;
//用类加载器加载资源文件
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderDemo2 {
    public static void main(String[] args) throws IOException {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //利用加载器去加载一个指定的文件
        //参数：文件的路径
        //返回值：字节流
        InputStream is = systemClassLoader.getResourceAsStream("prop.properties");//建立在src文件夹下
        Properties prop = new Properties();
        prop.load(is);
        System.out.println(prop);
        is.close();
    }
}
