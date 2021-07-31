package 日常练习.高级部分.注解.元注解;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})         //指定了注解使用的位置
@Retention(RetentionPolicy.RUNTIME)//可以存活到字节码（运行时）阶段
@Inherited//指定该注解可以被继承
public @interface Anno {

}
