package 正式课程.week5.exp7.content2;

public class MainClass {
    public static void main(String[] args) {
        Pet p = new Dog("乐乐", "棕色", "吉娃娃");
        p.speak();
        p = new Cat("咪咪", "白色", "波斯猫");
        p.speak();
    }
}
