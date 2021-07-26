package 日常练习.IO流.Properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo3 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.put("zhangsan","123");
        prop.put("lisi","456");
        prop.put("wangwu","789");

        FileWriter fw = new FileWriter("prop.properties");
        prop.store(fw,null);
        fw.close();
    }
}
