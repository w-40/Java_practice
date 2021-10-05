package 正式课程.week3.exp6;

public class Book {
    private int bid;
    public String name;
    public String author;
    public int number;
    public Category category;

    public Book(int bid, String name, String author, int number, Category category) {
        this.bid = bid;
        this.name = name;
        this.author = author;
        this.number = number;
        this.category = category;
    }

    public int getBid() {
        return bid;
    }

    @Override
    public String toString() {
        return "图书{" +
                "图书编号=" + bid +
                ", 图书名称='" + name + '\'' +
                ", 图书作者='" + author + '\'' +
                ", 图书数量=" + number +
                ", 图书类目=" + category +
                '}';
    }
}
