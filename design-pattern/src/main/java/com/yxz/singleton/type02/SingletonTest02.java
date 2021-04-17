package com.yxz.singleton.type02;

/**
 * @ClassName: SingletonTest02
 * @Description:单例模式之饿汉模式（静态代码块）
 * @Author: yangxiangzhong
 * @Date 2021/3/30
 * @Version 1.0
 **/
public class SingletonTest02 {

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
     private  static Singleton singleton;
     private Singleton(){}
     static {
         singleton = new Singleton();
     }
     public static Singleton getInstance(){
         return singleton;
     }

}
