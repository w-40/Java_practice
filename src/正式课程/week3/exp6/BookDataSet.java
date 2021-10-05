package 正式课程.week3.exp6;

import java.util.Scanner;

public class BookDataSet {
    private Book[] books;
    Scanner sc = new Scanner(System.in);


    public BookDataSet(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }
    public void modifyBook() {
        int index = 100;
        System.out.print("请输入要修改的书的编号：");
        int bid = sc.nextInt();
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBid() == bid) {
                index = i;
            }
        }
        if (index <= books.length) {
            System.out.print("请输入修改后图书名称：");
            books[index].name = sc.next();
            System.out.print("请输入修改后的图书作者：");
            books[index].author = sc.next();
            System.out.print("请输入修改后图书的数量:");
            books[index].number = sc.nextInt();
            System.out.print("请输入修改后商品一级类目：");
            books[index].category.firstLevel = sc.next();
            System.out.print("请输入修改后商品二级类目：");
            books[index].category.secondLevel = sc.next();
        } else {
            System.out.println("您的输入有误，图书不存在");
        }
    }

    public void searchBook() {
        System.out.print("请输入要查找的书的名字：");
        String name = sc.next();
        for (int i = 0; i < books.length; i++) {
            if (name.equals(books[i].name)) {
                System.out.println(books[i]);
            } else {
                System.out.println("没有找到该图书");
            }
        }
    }

    public void printBook() {
        System.out.println("书籍情况如下：");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }

    public void addBook() {
        System.out.print("请输入要录入的图书的数量：");
        int N = sc.nextInt();
        books = new Book[N];

        for (int i = 0; i < books.length; i++) {
            System.out.print("请输入书籍编号：");
            int bid = sc.nextInt();
            System.out.print("请输入书名：");
            String name = sc.next();
            System.out.print("请输入图书作者：");
            String author = sc.next();
            System.out.print("请输入该图书的数量:");
            int number = sc.nextInt();
            Category category = new Category(bid, "", "");
            System.out.print("请输入商品一级类目：");
            category.firstLevel = sc.next();
            System.out.print("请输入商品二级类目：");
            category.secondLevel = sc.next();
            Book book = new Book(bid, name, author, number, category);
            books[i] = book;
        }
    }
}
