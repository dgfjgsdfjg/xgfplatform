package com.cmpay.xgf;

import java.lang.annotation.*;


/**
 * @author xgf
 * 权限注解用于拦截接口权限
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
@Inherited
public @interface Power {

    //注解的name属性
    String value() default "";
}
