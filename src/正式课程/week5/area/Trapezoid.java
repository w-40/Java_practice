package 正式课程.week5.area;

public class Trapezoid extends Shape {
    private float topBottom;

    public Trapezoid(float bottom, float height, float topBottom) {
        super(bottom, height);
        this.topBottom = topBottom;
    }

    @Override
    public float getArea() {
        return (side1 + topBottom) * side2 / 2;
    }

    @Override
    public String toString() {
        return "上底为" + topBottom + "高为" + side2 + "下底为" + side1 + "的梯形";
    }
}
