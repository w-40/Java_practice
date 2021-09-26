package 正式课程.week1.exp1;

//定义学生类（模板）
class Student {
    public String name;

    public Student() {
    }

    //说话的功能
    public void speak() {
        System.out.println(name + "说:Hello World!");
    }
}
//定义主类
public class TestHello2 {
    public static void main(String[] args) {
        //用类创建对象
        Student stu = new Student();
        stu.name = "王志凯";
        stu.speak();
    }
}
