package 日常练习.高级部分.单元测试;

import org.junit.Test;

public class JunitDemo1 {
    public static void main(String[] args) {

    }

    @Test
    public void add(){
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println(sum);
    }
}
