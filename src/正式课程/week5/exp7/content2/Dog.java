package 正式课程.week5.exp7.content2;

public class Dog extends Pet {
    public Dog(String name, String color, String breed) {
        super(name, color, breed);
    }

    @Override
    public void cry() {
        System.out.println("汪汪汪...");
    }

    @Override
    public String toString() {
        return "狗";
    }
}
