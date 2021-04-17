package com.yxz.singleton.type01;

/**
 * @ClassName: SingletonTest01
 * @Description: 单例模式之饿汉模式 （静态变量）
 * @Author: yangxiangzhong
 * @Date 2021/3/30
 * @Version 1.0
 **/
public class SingletonTest01 {

    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}

class Singleton {
    //私有化构造器
    private Singleton() {
    }
    //创建对象
    private final static Singleton singleton = new Singleton();
    //提供返回对象实例
    public static Singleton getInstance() {
        return singleton;
    }

}
