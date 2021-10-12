package 正式课程.week5.area;

public class Circle extends Shape {
    public Circle(float r) {
        super(r);
    }

    @Override
    public float getArea() {
        return (float) Math.PI * side1 * side1;
    }

    @Override
    public String toString() {
        return "半径为" + side1 + "的圆";
    }
}
