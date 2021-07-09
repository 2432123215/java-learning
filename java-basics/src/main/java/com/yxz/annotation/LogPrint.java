package com.yxz.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogPrint{
    //可附加属性
    public String desc();//注意属性后面有括号
}