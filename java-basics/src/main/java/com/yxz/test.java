package com.yxz;

public class test {

    public static void main(String[] args) {
        String s="A/b/c";
        String s1="A";
        for (int i = 0; i < s.split("/").length; i++) {
            System.out.println(s.split("/")[i]);
        }
        for (int i = 0; i < s1.split("/").length; i++) {
            System.out.println(s.split("/")[i]);
        }

    }
}

