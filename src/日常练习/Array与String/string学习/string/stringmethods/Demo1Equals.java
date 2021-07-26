package 日常练习.Array与String.string学习.string.stringmethods;

public class Demo1Equals {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ABC";
        String s3 = "abc";
        //比较字符串
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        //忽略大小写比较字符串
        System.out.println(s1.equalsIgnoreCase(s2));

    }
}
