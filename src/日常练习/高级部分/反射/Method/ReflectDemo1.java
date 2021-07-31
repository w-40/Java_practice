package 日常练习.高级部分.反射.Method;

import java.lang.reflect.Method;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //method1();返回所有成员方法对象的数组，包括继承的
        //method2();返回所有成员方法对象的数组，不包括继承的
        //method3();返回单个成员方法对象
        //method4();返回单个成员方法对象,带参数
        //method5();返回单个私有成员方法对象
    }

    private static void method5() throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("日常练习.高级部分.反射.Method.Student");
        Method method = clazz.getDeclaredMethod("show");
        System.out.println(method);
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.Method.Student");
        //2.获取一个有形参的方法function2
        Method method = clazz.getMethod("function2", String.class);
        System.out.println(method);
    }

    private static void method3() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.Method.Student");
        Method method1 = clazz.getMethod("function1");//返回单个成员方法对象
        System.out.println(method1);
    }

    private static void method2() throws ClassNotFoundException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.Method.Student");
        Method[] methods = clazz.getDeclaredMethods();//返回所有成员方法对象的数组，不包括继承的
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.Method.Student");
        //2.获取Method对象
        Method[] methods = clazz.getMethods();//返回所有成员方法对象的数组，包括继承的
        //3.遍历一下数组
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
