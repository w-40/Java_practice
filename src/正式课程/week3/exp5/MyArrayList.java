package 正式课程.week3.exp5;

import java.util.Scanner;

public class MyArrayList {
    Scanner sc = new Scanner(System.in);
    private String[] data;
    private int size;
    private int CAPACITY;

    // 1.初始化线性表
    public void initArray() {
        System.out.println("请输入要初始化的线性表的元素个数:");
        int count = sc.nextInt();
        data = new String[count];
        for (int i = 0; i < data.length; i++) {
            int k = i + 1;
            System.out.println("请输入第" + k + "个元素的值：");
            data[i] = sc.next();
        }
    }

    // 2.插入元素
    public void insertArray() {
        System.out.println("请输入要插入的元素的位置(从1开始)：");
        int index = sc.nextInt();
        index--;
        System.out.println("请输入要插入的元素的值");
        String value = sc.next();

        String[] newData = new String[data.length + 1];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        for (int i = newData.length - 1; i > index; i--) {
            newData[i] = newData[i - 1];
        }
        newData[index] = value;
        data = newData;
    }

    // 3.查询元素
    public void searchData() {
        System.out.println("请输入要查询的元素：");
        String element = sc.next();

        for (int i = 0; i < data.length; i++) {
            if (element.equals(data[i])) {
                int index = i + 1;
                System.out.println("查询成功，该元素在线性表的第" + index + "个索引位置(从1开始)");
                return;
            }
        }
        System.out.println("未查询到该元素");
    }

    // 4.遍历线性表
    public void printArray() {
        System.out.println("线性表为：");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void deleteData() {
        System.out.println("请输入要删除的元素的位置(从1开始)：");
        int index = sc.nextInt();
        index--;
        String[] newData = new String[data.length - 1];
        for (int i = 0; i < data.length - 1; i++) {
            if (i < index) {
                newData[i] = data[i];
            } else {
                newData[i] = data[i + 1];
            }
        }
        data = newData;
        System.out.println("删除成功");
    }

    public int getLength() {
        return data.length;
    }

    public void isEmpty() {
        if (data != null) {
            System.out.println("线性表不为空");
        } else {
            System.out.println("线性表为空");
        }
    }

    public void clearArray() {
        data = null;
    }

    public void isData() {
        System.out.println("请输入要判断的元素：");
        String element = sc.next();

        for (int i = 0; i < data.length; i++) {
            if (element.equals(data[i])) {
                System.out.println("线性表中包含该元素");
                return;
            }
        }
        System.out.println("线性表中不包含该元素");
    }

    public void tailInsert() {
        System.out.println("请输入要插入的元素的值");
        String value = sc.next();
        String[] newData = new String[data.length + 1];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        newData[newData.length - 1] = value;
        data = newData;
    }
}


