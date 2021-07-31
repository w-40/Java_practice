package 日常练习.高级部分.反射.获取创建Constructor对象;
//根据指定的构造方法创建对象
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //method1();有参
        //method2();无参
        //method3();过时（了解一下）
        //method4();根据私有的构造方法创建对象//暴力反射
    }

    private static void method4() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.获取创建Constructor对象.Student");
        //2.获取一个私有化的构造方法
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        //被private修饰的成员，不能直接使用的
        //如果反射强行获取并使用，需要临时取消访问检查
        constructor.setAccessible(true);
        //3.直接创建对象
        Student student = (Student) constructor.newInstance("张三");
        System.out.println(student);
    }

    private static void method3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.获取创建Constructor对象.Student");
        //2.在Class类中，有一个newInstance方法，可以利用空参直接创建一个对象
        Student student = (Student)clazz.newInstance();
        System.out.println(student);
    }

    private static void method2() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.获取创建Constructor对象.Student");
        //2.获取构造方法对象
        Constructor constructor = clazz.getConstructor();//返回单个公共构造方法对象
        //3.利用空参来创建Student的对象
        Student student = (Student) constructor.newInstance();
        System.out.println(student);
    }

    private static void method1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.获取创建Constructor对象.Student");
        //2.获取构造方法对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);//返回单个公共构造方法对象
        System.out.println(constructor);
        //3.利用newInstance创建Student的对象
        Student student = (Student) constructor.newInstance("张三", 23);
        System.out.println(student);
    }
}
