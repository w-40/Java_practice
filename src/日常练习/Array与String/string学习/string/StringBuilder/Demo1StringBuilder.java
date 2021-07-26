package 日常练习.Array与String.string学习.string.StringBuilder;

public class Demo1StringBuilder {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 50000; i++) {
            sb.append(i);
        }
        System.out.println(sb);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void method() {
        long start = System.currentTimeMillis();//获取1970年1月1日0时0分0秒到当前时间所经历过的毫秒值
        String s = "";
        for (int i = 0; i <= 50000; i++) {
            s += i;
        }
        System.out.println(s);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
