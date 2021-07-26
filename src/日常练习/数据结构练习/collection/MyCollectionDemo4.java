package 日常练习.数据结构练习.collection;
//普通删除元素方法
import java.util.ArrayList;

public class MyCollectionDemo4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if ("b".equals(s)) {
                list.remove(i);
                i--;
            }

        }
        System.out.println(list);
    }
}
