package 日常练习.高级部分.反射.Filed;

import java.lang.reflect.Field;

/*
* 利用Field对象，获取值或者修改值
* */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //method1();
        //method2();

    }

    private static void method2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        //1.
        Class clazz = Class.forName("日常练习.高级部分.反射.Filed.Student");
        //2.获取成员变量Field的对象
        Field field = clazz.getDeclaredField("money");
        //3.取消一个访问检查
        field.setAccessible(true);
        //4.调用get方法来获取值
        //4.1创建一个对象
        Student student = (Student)clazz.newInstance();
        //4.2获取指定对象的money值
        Object o = field.get(student);
        System.out.println(o);
    }

    private static void method1() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("日常练习.高级部分.反射.Filed.Student");
        //获取name这个Field对象
        Field field = clazz.getField("name");
        //3.利用set方法进行赋值
        //3.1线创建一个Student对象
        Student student = (Student)clazz.newInstance();
        //3.2有了对象才可以给指定对象进行赋值
        field.set(student,"张三");

        System.out.println(student);
    }
}
