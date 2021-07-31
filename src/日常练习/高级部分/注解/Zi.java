package 日常练习.高级部分.注解;


@SuppressWarnings(value = "all")
//表示压制本类中的警告
public class Zi extends Fu{
    @Override//告诉编译器这个方法是重写了父类中的show方法
            //那么我们在进行方法定义的时候，就需要按照重写方法的要求进行方法定义
    public void show() {
        System.out.println("子类的方法");
    }

    //表示这是一个过时的方法
    @Deprecated
    public void method(){
        System.out.println("method.......");
    }

    @SuppressWarnings(value = "all")
    //表示压制本方法中的警告
    public void function(){
        int a = 10;
        int b = 20;
    }
}
