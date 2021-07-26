package 日常练习.数据结构练习.collection;

import java.util.ArrayList;
import java.util.Collection;
//Collection常用方法
public class MyCollectionDemo2 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("dddd");
        //System.out.println(collection);
        //method1(collection);
        //method2(collection);
        //method3(collection);
        //method4(collection);
        //method5(collection);
        //method6(collection);
    }

    private static void method6(Collection<String> collection) {
        int size = collection.size();
        System.out.println(size);
    }

    private static void method5(Collection<String> collection) {
        collection.clear();
        boolean result = collection.isEmpty();

        System.out.println(result);
    }

    private static void method4(Collection<String> collection) {
        boolean result1 = collection.contains("a");
        boolean result2 = collection.contains("aaa");
        System.out.println(result1);
        System.out.println(result2);
    }

    private static void method3(Collection<String> collection) {
        collection.clear();
        System.out.println(collection);
    }

    private static void method2(Collection<String> collection) {
        collection.removeIf(
                //s依次表示集合中的每一个元素
                //就会把这每一个元素都到lambda表达式中去判断一下
                //如果返回是true，则删除
                //如果返回false，则保留不删除
                (String s)->{
                    return s.length() == 3;
                }
        );
        System.out.println(collection);
    }

    private static void method1(Collection<String> collection) {
        //从集合中移除指定元素
        //删除成功返回true，删除失败返回false
        boolean result1 = collection.remove("aaa");
        boolean result2 = collection.remove("ddd");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(collection);
    }
}
