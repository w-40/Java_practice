package 正式课程.week5.area;

public class TestArea {
    public static void main(String[] args) {
        Circle c = new Circle(2);
        System.out.println(c + "的面积为：" + c.getArea());
        Rectangle r = new Rectangle(2, 3);
        System.out.println(r + "的面积为：" + r.getArea());
        Trapezoid t = new Trapezoid(5, 3, 2);
        System.out.println(t + "的面积为：" + t.getArea());
    }
}
