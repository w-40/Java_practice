package 正式课程.week3.practice;

public class TestBall {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Circle c = new Circle(2);
        Pillar p = new Pillar(c, 5);
        Ball b = new Ball(c, 5);
        float v = b.getVolume() + p.getVolume();
        System.out.println("花瓶的体积为：" + v);
    }
}
