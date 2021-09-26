package 正式课程.week1.exp1;

public class TestHello3 {
    public static void main(String[] args) {
        People p1 = new People("老师");
        People p2 = new People("王志凯");
        People p3 = new People("籍乃博");

        p1.speak("你喜欢学Java吗？");
        p2.speak("我喜欢!");
        p3.speak("我不喜欢!");
    }
}
