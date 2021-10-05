package 正式课程.week3.exp6;

import java.util.Scanner;

public class MainClass {
    static Book[] books;
    static Scanner sc = new Scanner(System.in);
    static BookDataSet bookDataSet = new BookDataSet(books);

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();

        while (true) {
            System.out.println("------电商购物平台------");
            System.out.println("1 录入商品");
            System.out.println("2 修改商品");
            System.out.println("3 查看商品");
            System.out.println("4 查询商品");
            System.out.println("请输入您的选择");

            String choice = sc.next();

            switch (choice) {
                case "1":
                    bookDataSet.addBook();
                    break;
                case "2":
                    bookDataSet.modifyBook();
                    break;
                case "3":
                    bookDataSet.printBook();
                    break;
                case "4":
                    bookDataSet.searchBook();
                    break;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
}
