package 正式课程.week3.practice;

public class Pillar {
    Circle bottom;
    float height;

    public Pillar(Circle bottom, float height) {
        this.bottom = bottom;
        this.height = height;
    }

    public float getVolume() {
        return bottom.getArea() * height;
    }
}
