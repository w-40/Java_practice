package 日常练习.高级部分.注解.元注解;

public class StudentDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取到Student类的字节码文件对象
        Class clazz = Class.forName("日常练习.高级部分.注解.元注解.Student");

        //获取注解
        boolean result = clazz.isAnnotationPresent(Anno.class);
        System.out.println(result);
    }
}
