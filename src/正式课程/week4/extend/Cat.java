package 正式课程.week4.extend;

public class Cat extends Pet {
    public Cat(String name, String color, String breed) {
        super(name, color, breed);
    }

    @Override
    public void cry() {
        System.out.println("喵喵喵...");
    }

    @Override
    public String toString() {
        return "猫";
    }

}
