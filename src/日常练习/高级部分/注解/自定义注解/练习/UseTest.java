package 日常练习.高级部分.注解.自定义注解.练习;



public class UseTest {
    //没有使用Test注解
    public void show(){
        System.out.println("UseTest....show....");
    }
    //使用Test注解
    @Test
    public void method(){
        System.out.println("UseTest....method....");
    }
    //没有使用Test注解
    @Test
    public void function(){
        System.out.println("UseTest....function....");
    }
}
