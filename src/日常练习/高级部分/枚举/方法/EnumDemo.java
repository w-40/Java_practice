package 日常练习.高级部分.枚举.方法;

public class EnumDemo {
    public static void main(String[] args) {
        String name = Season.SPRING.name();//1.获取枚举项的名称
        System.out.println(name);
        System.out.println("--------------");

        int index1 = Season.SPRING.ordinal();//返回枚举项的索引值
        int index2 = Season.SUMMER.ordinal();
        int index3 = Season.AUTUMN.ordinal();
        int index4 = Season.WINTER.ordinal();
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
        System.out.println("--------------");

        //3.
        int result = Season.SPRING.compareTo(Season.WINTER);//比较两个枚举项，返回的是索引值的差值
        System.out.println(result);//-3
        System.out.println("--------------");

        //4.
        String s = Season.SPRING.toString();//返回枚举常量的名称
        System.out.println(s);
        System.out.println("--------------");

        //5.
        Season spring = Enum.valueOf(Season.class, "SPRING");//获取指定枚举类中的指定名称的枚举值
        System.out.println(spring);
        System.out.println(Season.SPRING == spring);
        System.out.println("--------------");

        //6.
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }
    }
}
