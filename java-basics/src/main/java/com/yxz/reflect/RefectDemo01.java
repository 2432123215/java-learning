package com.yxz.reflect;

import com.yxz.reflect.dao.Person;

import java.lang.reflect.Field;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
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
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void fieldShoe() throws NoSuchFieldException {
        //默认取出public的字段
        Class<Person> personClass = Person.class;
        Field[] fields;
        fields =  personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
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

    }
}
