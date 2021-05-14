package com.yxz.reflect.dao;

/**
 * @ClassName: Person
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/5/14
 * @Version 1.0
 **/
public class Person {
    public String name;
    protected String type;
    String age;
    private String idNo;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", idNo='" + idNo + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
