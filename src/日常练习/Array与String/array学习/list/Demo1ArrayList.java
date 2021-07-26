package 日常练习.Array与String.array学习.list;

import java.util.ArrayList;

public class Demo1ArrayList {
    public static void main(String[] args) {
        //集合容器如果没有加入<>,就可以存储任意数据类型
        //<> 泛型: 对集合容器存储的数据类型进行限制
        ArrayList<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add(0,"666");

        System.out.println(list);
    }
}
