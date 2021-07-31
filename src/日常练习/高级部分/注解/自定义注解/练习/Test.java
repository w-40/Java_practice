package 日常练习.高级部分.注解.自定义注解.练习;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//表示Test这个注解的存活时间
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Test {
}
