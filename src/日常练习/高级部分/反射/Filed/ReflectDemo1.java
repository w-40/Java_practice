package 日常练习.高级部分.反射.Filed;
//获取Field对象
import java.lang.reflect.Field;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        //method1();
        //method2();
        //method3();
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.Filed.Student");
        //2.获取成员变量
        Field field = clazz.getDeclaredField("money");
        System.out.println(field);

    }

    private static void method3() throws ClassNotFoundException, NoSuchFieldException {
        //需要获得的成员变量必须是真实存在的
        //且必须是public修饰的
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.Filed.Student");
        Field field = clazz.getField("name");
        //3.输出
        System.out.println(field);
    }

    private static void method2() throws ClassNotFoundException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.Filed.Student");
        //2.获取所有的Filed对象
        Field[] fields = clazz.getDeclaredFields();
        //3.遍历
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    private static void method1() throws ClassNotFoundException {
        //1.获取Class对象
        Class clazz = Class.forName("日常练习.高级部分.反射.Filed.Student");

        //2.获取Filed对象
        Field[] fields = clazz.getFields();
        //3.遍历
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}
