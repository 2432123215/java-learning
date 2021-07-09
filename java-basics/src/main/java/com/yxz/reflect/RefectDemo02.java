package com.yxz.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

public class RefectDemo02 {
    public static void main(String[] args) throws Exception {
        show();
    }

    private static void show() throws Exception {
        //1加载配置文件
        //1.1创建properties对象
        Properties pro = new Properties();
        //1.2加载配置文件转换成一个集合
        //1.2.1获取目录下的配置文件
        //获取当前类的类加载器 （这类是由类加载器，加载进入内存的，同时类加载可以获取到同目录下的文件）
        ClassLoader classLoader = RefectDemo02.class.getClassLoader();
        System.out.println(classLoader);
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        URL resource = classLoader.getResource("pro.properties");
        System.out.println(resource);
//        if (resourceAsStream!=null) {
//            throw new Exception("fff");
//        }
        if (resourceAsStream!=null) {
            pro.load(resourceAsStream);
        }else {
            System.out.println("未读取到属性文件");
            //因为无法加载到属性文件，只能强制加载
            FileInputStream fileInputStream = new FileInputStream("java-basics/src/main/resources/pro.properties");
            pro.load(fileInputStream);
        }
        //2取出配置文件的信息
        String className = pro.getProperty("className");
        System.out.println(className);
        String mothodName = pro.getProperty("methodName");
        System.out.println(mothodName);
        Object className1 = pro.get("className");
        System.out.println(className1);

        Set<String> strings = pro.stringPropertyNames();
        for (String string : strings) {
            System.out.println("==");
            System.out.println(string);
            System.out.println("==");
        }

        //3.加载类进入内存中
        Class<?> aClass = Class.forName(className);
        //4.创建对象
        Object o = aClass.newInstance();
        //5.获取方法的对象
        Method method = aClass.getMethod(mothodName);
        //6.执行方法
        method.invoke(o);

    }
}
