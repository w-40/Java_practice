package 正式课程.week3.practice;

public class Ball {
    Circle bottom;
    float r;

    public Ball(Circle bottom, float r) {
        this.r = r;
        this.bottom = bottom;
    }

    public float getVolume() {
        return bottom.getArea() * r;
    }
}
