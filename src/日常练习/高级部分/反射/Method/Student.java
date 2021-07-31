package 日常练习.高级部分.反射.Method;

public class Student {
    //私有的，无参无返回值
    private void show() {
        System.out.println("私有的show方法，无参无返回值");
    }

    //公共的，无参无返回值
    public void function1() {
        System.out.println("function1方法，无参无返回值");
    }

    //公共的，有参无返回值
    public void function2(String name) {
        System.out.println("function2方法，有参无返回值，参数为" + name);
    }

    //公共的，无参有返回值
    public String function3() {
        System.out.println("function3方法，无参有返回值");
        return "aaa";
    }

    //公共的，有参有返回值
    public String function4(String name) {
        System.out.println("function4方法，有参有返回值" + name);
        return "aaa";
    }
}
