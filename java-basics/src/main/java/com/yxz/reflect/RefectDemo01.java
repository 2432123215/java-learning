package com.yxz.reflect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yxz.reflect.dao.Person;

import java.lang.reflect.Field;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

/**
 * @ClassName: RefectDemo01
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/5/14
 * @Version 1.0
 **/
public class RefectDemo01 {
    public static void main(String[] args) {

        try {
            fieldShoe();
//            methodShow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void methodShow() throws Exception {
        Class<Person> personClass = Person.class;
        Person person = new Person();
        //指定方法
        Method method = personClass.getMethod("eat");
        Object invoke = method.invoke(person);
        Method eag = personClass.getMethod("eat", String.class);
        Object yu = eag.invoke(person, "yu");
        System.out.println(yu);

        Method[] declaredMethods = personClass.getDeclaredMethods();
        List<Method> methods = Arrays.asList(declaredMethods);
        for (Method method1 : methods) {
            System.out.println(method1);
        }




    }

    private static void fieldShoe() throws Exception, IllegalAccessException {
        //默认取出public的字段
        /**
         * 1. 设置值
         * 			* void set(Object obj, Object value)
         * 2. 获取值
         * 			* get(Object obj)
         */
        Class<Person> personClass = Person.class;
        Field[] fields;
        //获取public方法的属性
        fields =  personClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());//name
        }

        System.out.println("=======");
        List<Field> fieldList = Arrays.asList(fields);
        fieldList.forEach(p->{
            System.out.println(p);
        });

        fieldList.forEach(p-> System.out.println(p));
        System.out.println("=======");
        fieldList.forEach(System.out::println);
        System.out.println("=======");
        //取出所有字段
        fields = personClass.getDeclaredFields();
        for (Field declaredField : fields) {
            System.out.println(declaredField);
        }
        System.out.println("=======");
        //取出特定字段
        Field age = personClass.getDeclaredField("age");
        System.out.println(age);

        System.out.println("=======");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Consumer<Person> ac= System.out::println;
        Person person1 = new Person();

        Consumer<Person> action = Person::getAge;
        Consumer<Person> action1 = person -> {
            System.out.println(person.getAge());
        };
        Consumer<Person> action2 = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person.getAge());
            }
        };
        /**
         * 暴力反射
         */
        System.out.println("idNo私有方法的测试");
        Person person = new Person();
        Field idNo = personClass.getDeclaredField("idNo");
        //暴力反射，如果不是设置未TRUE ，会报没有权限的错误
        idNo.setAccessible(true);
        System.out.println(idNo);
        idNo.set(person,"111");
        System.out.println(idNo.get(person));

        /**
         * 通过反射来进行get和set方法；
         */
        System.out.println("mobile私有方法的测试");
        Field mobile = personClass.getDeclaredField("mobile");
        String setmethod ="set"+mobile.getName().substring(0,1).toUpperCase()+mobile.getName().substring(1);
        Method method = personClass.getMethod(setmethod, String.class);
        Object invoke = method.invoke(person, "15591471551");

        System.out.println(mobile.getName().substring(0,1));
        System.out.println(mobile.getName().substring(1));
        String getmethod ="get"+mobile.getName().substring(0,1).toUpperCase()+mobile.getName().substring(1);
        System.out.println(getmethod);

        Method method2 = personClass.getMethod(getmethod);
        Object invoke1 = method2.invoke(person);
        System.out.println(invoke1);
        /**
         * 把 string 转换成 map集合
         */
        //WriteNullStringAsEmpty : 字符类型字段如果为null,输出为”“,而非null
        //WriteMapNullValue : 是否输出值为null的字段,默认为false
        Map<String, String> map1 = JSONObject.parseObject(JSON.toJSONString(person, SerializerFeature.WriteNullStringAsEmpty), Map.class);
        Set<String> strings = map1.keySet();
        for (String string : strings) {
            System.out.println(string+":"+map1.get(string));
//            System.out.println(map1.get(string));
        }
    }
}
