package 正式课程.week3.exp6;

public class Category {
    private int id;
    public String firstLevel;
    public String secondLevel;

    public Category(int id, String firstLevel, String secondLevel) {
        this.id = id;
        this.firstLevel = firstLevel;
        this.secondLevel = secondLevel;
    }

    @Override
    public String toString() {
        return "{" +
                "图书编号=" + id +
                ", 一级类目='" + firstLevel + '\'' +
                ", 二级类目='" + secondLevel + '\'' +
                '}';
    }
}
