package 日常练习.高级部分.枚举.特点;

public class EnumDemo {
    public static void main(String[] args) {
        /*
        * 1.所有的枚举类都是Enum的子类
        * 2.我们可以通过"枚举类名.枚举项名称"去访问指定的枚举项
        * 3.每一个枚举项其实就是该枚举的一个对象
        * 4.枚举也是一个类，也可以去定义成员变量
        * 5.枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的
        * 但是如果枚举类有其他的东西，这个分号就不能省略，建议不要省略
        * 6.枚举类可以有构造器，但必须是private的，它默认的也是private的
        * 枚举项的用法比较特殊：枚举("")
        * 7.枚举类也可以有抽象方法，但是枚举项必须重写该方法
        * */

        //2.演示
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);
        //3.演示
        Season spring = Season.SPRING;
    }
}
