package 正式课程.week3.exp5;

import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("--------课程融合之线性表--------");
            System.out.println("1 线性表的初始化");
            System.out.println("2 插入元素");
            System.out.println("3 查找元素");
            System.out.println("4 遍历线性表");
            System.out.println("5 删除元素");
            System.out.println("6 返回线性表长度");
            System.out.println("7 线性表判空");
            System.out.println("8 清空线性表");
            System.out.println("9 判断线性表中是否包含某个元素");
            System.out.println("10 末尾插入元素");
            System.out.println("请输入您的选择");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    list.initArray();
                    break;
                case "2":
                    list.insertArray();
                    break;
                case "3":
                    list.searchData();
                    break;
                case "4":
                    list.printArray();
                    break;
                case "5":
                    list.deleteData();
                    break;
                case "6":
                    System.out.println("线性表长度为：" + list.getLength());
                    break;
                case "7":
                    list.isEmpty();
                    break;
                case "8":
                    list.clearArray();
                    break;
                case "9":
                    list.isData();
                    break;
                case "10":
                    list.tailInsert();
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
}
