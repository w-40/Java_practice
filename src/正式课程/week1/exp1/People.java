package 正式课程.week1.exp1;

public class People {
    private String name;

    public People() {
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {//方法名首字母小写，驼峰格式
        this.name = name;
    }
    //说话的功能，想说啥说啥
    public void speak(String sentence){
        System.out.println(name + "说：" + sentence);
    }
}
