package 日常练习.IO流.Properties;
//读取配置文件中的键值对并写入集合中
//手写properties文件时不加标点符号，不加空格，直接键=值
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("prop.properties");
        prop.load(fr);
        fr.close();
        System.out.println(prop);
    }
}
