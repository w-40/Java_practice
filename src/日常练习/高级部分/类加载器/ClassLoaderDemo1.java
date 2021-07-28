package 日常练习.高级部分.类加载器;

public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        //获得系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //获取系统类加载器的父加载器---平台类加载器
        ClassLoader classLoader1 = systemClassLoader.getParent();
        //获取平台类加载器的父加载器---启动类加载器
        ClassLoader classLoader2 = classLoader1.getParent();

        System.out.println("系统类加载器" + systemClassLoader);
        System.out.println("平台类加载器" + classLoader1);
        System.out.println("平台类加载器" + classLoader2);
    }
}
