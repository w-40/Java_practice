package 正式课程.week5.exp7.content2;

public class Pet {
    protected String name;
    protected String color;
    protected String breed;

    public Pet(String name, String color, String breed) {
        this.name = name;
        this.color = color;
        this.breed = breed;
    }

    public void cry() {
    }

    public void speak() {
        System.out.println("我是一只" + toString() + "。我叫" + name +
                ",是一只" + color + "的" + breed + "。我会");
        cry();
    }
}
