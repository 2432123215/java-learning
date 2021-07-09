package com.yxz.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Before;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LogPrintAspect {
    //自定义切点位置    
    //把切面连接点放在我们注解上    
    @Pointcut("@annotation(com.test.aop.service.LogPrint)")
    private void controllerAspect() {
    }

    //自定义前置切面    
    //访问controller方法前先执行的方法    
    @Before()
    public void printLog() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");
        System.out.println(sdf.format(new Date()) + " || ");
    }
}