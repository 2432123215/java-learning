package com.yxz.singleton.type03;

/**
 * @ClassName: SingletonTest03
 * @Description:懒汉模式 (线程不安全)
 * @Author: yangxiangzhong
 * @Date 2021/3/30
 * @Version 1.0
 **/
public class SingletonTest03 {
    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance1.hashCode());

    }


}

class Singleton {
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
