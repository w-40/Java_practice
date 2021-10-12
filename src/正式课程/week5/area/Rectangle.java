package 正式课程.week5.area;

public class Rectangle extends Shape {
    public Rectangle(float bottom, float height) {
        super(bottom, height);
    }

    @Override
    public float getArea() {
        return side1 * side2;
    }

    @Override
    public String toString() {
        return "底为" + side1 + "高为" + side2 + "的矩形";
    }
}
