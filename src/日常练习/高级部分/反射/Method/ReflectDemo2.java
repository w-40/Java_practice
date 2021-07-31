package 日常练习.高级部分.反射.Method;
/*
* 获取Method对象并运行
* */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /*
        参数一：用obj对象调用该方法
        参数二：调用方法的传递的参数（如果没有就不写）
        返回值：方法的返回值（如果没有就不写）
        * */
        Class clazz = Class.forName("日常练习.高级部分.反射.Method.Student");
        //2.获取里面的Method方法
        Method method = clazz.getMethod("function4", String.class);
        //3.运行function4方法就可以了
        //3.1创建一个Student对象，当做方法的调用者
        Student student = (Student) clazz.newInstance();
        //3.2运行方法
        Object result = method.invoke(student, "张三");
        //4.
        System.out.println(result);
    }
}
