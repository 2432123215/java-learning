package com.yxz.singleton.type04;

/**
 * @ClassName: SingletonTest04
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/3/30
 * @Version 1.0
 **/
public class SingletonTest04 {

    public static void main(String[] args) {
        System.out.println("懒汉式 2 ， 线程安全~");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // true
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }

}

// 懒汉式(线程安全，同步方法)
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    //即懒汉式
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}