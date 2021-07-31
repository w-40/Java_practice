package 日常练习.高级部分.反射.获取创建Constructor对象;

import java.lang.reflect.Constructor;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //method1();返回所有公共构造方法对象的数组
        //method2();返回所有构造方法对象的数组
        //method3();返回单个公共构造方法对象
        //method4();返回单个构造方法对象
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.获取创建Constructor对象.Student");
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);//返回单个构造方法对象
        System.out.println(declaredConstructor);
    }

    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.获取创建Constructor对象.Student");
        //小括号中。一定要跟构造方法的形参保持一致
        Constructor constructor1 = clazz.getConstructor();//返回单个公共构造方法对象
        System.out.println(constructor1);

        Constructor constructor2 = clazz.getConstructor(String.class, int.class);//返回单个公共构造方法对象
        System.out.println(constructor2);
        //因为Student类中，没有只有一个int的构造，所以这里会报错
        /*Constructor constructor3 = clazz.getConstructor(int.class);
        System.out.println(constructor3);*/
    }

    private static void method2() throws ClassNotFoundException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.获取创建Constructor对象.Student");
        Constructor[] constructors = clazz.getDeclaredConstructors();//返回所有构造方法对象的数组
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.获取创建Constructor对象.Student");
        Constructor[] constructors = clazz.getConstructors();//返回所有公共构造方法对象的数组
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
