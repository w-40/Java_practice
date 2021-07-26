package 日常练习.IO流.File;

import java.io.File;
import java.io.IOException;

public class FileDemo4 {
    public static void main(String[] args) throws IOException {
        File file = new File("Java学习\\src\\日常练习\\File\\aaa");
        if (!file.exists()){
            file.mkdirs();
        }
        File newFile = new File(file,"a.txt");
        newFile.createNewFile();
    }
}
