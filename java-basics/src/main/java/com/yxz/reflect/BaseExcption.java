package com.yxz.reflect;

public class BaseExcption extends RuntimeException{

    /*
       为什么要定义构造函数，因为看到Java中的异常描述类中有提供对异常对象的初始化方法。
    */
    BaseExcption(){
        super();
    }
    BaseExcption(String message)    {
        super(message);
        // 如果自定义异常需要异常信息，可以通过调用父类的带有字符串参数的构造函数即可。
    }
}
