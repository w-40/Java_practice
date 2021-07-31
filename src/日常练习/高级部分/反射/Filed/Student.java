package 日常练习.高级部分.反射.Filed;

public class Student {
    public String name;
    public int age;
    public String gender;
    private int money = 300;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", money=" + money +
                '}';
    }
}
