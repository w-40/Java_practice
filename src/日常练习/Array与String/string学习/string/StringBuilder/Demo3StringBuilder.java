package 日常练习.Array与String.string学习.string.StringBuilder;

public class Demo3StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
//        sb.append("红色");
//        System.out.println(sb);
//        sb.append("蓝色");
//        System.out.println(sb);
//        sb.append("绿色");
//        System.out.println(sb);
//        StringBuilder sb2 = sb.append("红色");
//        StringBuilder sb3 = sb.append("蓝色");
        //链式编程：如果一个方法返回的是对象类型，对象就可以继续向下调用方法
        sb.append("红色").append("蓝色").append("绿色");
        System.out.println("反转前:" + sb);
        sb.reverse();
        System.out.println("反转后:" + sb);
        System.out.println("sb中字符的个数为：" + sb.length());
//        System.out.println(sb2);
//        System.out.println(sb3);
//        System.out.println(sb == sb2);
//        System.out.println(sb2 == sb3);
        String s = sb.toString();
        System.out.println(s);
    }
}
