package 日常练习.Array与String.array学习.list;

import java.util.ArrayList;

public class Demo2ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
//返回指定元素
        String s1 = list.get(0);
        String s2 = list.get(1);
        String s3 = list.get(2);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        int size = list.size();
        System.out.println(size);
    }

    private static void testset() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        String s = list.set(0,"666");
        System.out.println(s);
        System.out.println(list);
    }

    private static void testremove() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        boolean b1 = list.remove("abc");
        boolean b2 = list.remove("zzz");
        System.out.println(b1);
        System.out.println(b2);

        System.out.println(list);

        list.remove(0);
        System.out.println(list);
    }
}
