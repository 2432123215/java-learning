package com.yxz.reflect.dao;

import java.util.ArrayList;

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

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age='" + age + '\'' +
                ", idNo='" + idNo + '\'' +
                '}';
    }
    public void eat (){
        System.out.println("eat....");
    }
    public int eat (String food){
        System.out.println("eat...."+food);
        return 1;
    }
    private int water (String food){
        System.out.println("eat...."+food);
        return 1;
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

    public static void main(String[] args) {

        int n =5;

        System.out.println(566/100);
//        System.out.println(n + null);

        int i = 1;

        while (n >= 4) {
            if( (i = n % 4)!=0){
                break;
            }

            n = n / 4;

        }
        if (i == 0 && n == 1) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
//        ArrayList arrayList = new ArrayList();
//        ArrayList aa = new ArrayList();
//        ArrayList bb = new ArrayList();
//        ArrayList cc = new ArrayList();
//        while(l1!=null||l2!=null){
//            if(l1!=null){
//                aa.add(l1.val);
//            }
//            if(l2!=null){
//                bb.add(l2.val);
//            }
//        }
//        i =aa.size();
//        if(aa.size()<bb.size()){
//            i=bb.size();
//
//        }
//        for(int j=0;j<i;j++){
//            if(aa.get(j)!=null&&bb.get(j)!=null){
//                if(){
//
//                }
//
//            }else {
//
//            }
//
//        }
//        ArrayList aa = new ArrayList();
//        ArrayList bb = new ArrayList();
//        ArrayList cc = new ArrayList();
//        while(l1!=null||l2!=null){
//            if(l1!=null){
//                aa.add(l1.val);
//            }
//            if(l2!=null){
//                bb.add(l2.val);
//            }
//        }
//        i =aa.size();
//        if(aa.size()<bb.size()){
//            i=bb.size();
//
//        }
//        for(int j=0;j<i;j++){
//            if(aa.get(j)!=null&&bb.get(j)!=null){
//                if(){
//
//                }
//
//            }else {
//
//            }
//
//        }
//
//        for (int i1 = 0; i1 < arrayList.size(); i1++) {
//
//        }


//        while(l1!=null||l2!=null){
//            if(l1!=null){
//                a=a+l1.val*i;
//            }
//            if(l2!=null){
//                b=b+l2.val*i;
//            }
//            i=i*10;
//        }
//        sum =a+b;
    }



}

