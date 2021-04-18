package com.yxz.flie;

import java.io.File;

/**
 * @ClassName: File
 * @Description: file学习
 * @Author: yangxiangzhong
 * @Date 2021/4/13
 * @Version 1.0
 **/
public class Demo01File {
    public static void main(String[] args) {

        test();
        test1();

    }

    public static void test() {
        //表示当前目录
        File path = new File("");
        System.out.println(path.getAbsolutePath());
        File f = new File("C:\\Users\\yxz\\Desktop\\课件笔记源码资料\\4_文档资料\\API文档2\\1.txt");
        
        boolean mkdirs = f.mkdirs();
        System.out.println(mkdirs);
        File file = new File("C:\\Users\\yxz\\Desktop\\课件笔记源码资料\\4_文档资料\\API文档");
        //API文档
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        //4096  ??
        System.out.println(file.length());
        System.out.println(new File("C:\\Users\\yxz\\Desktop\\课件笔记源码资料\\4_文档资料\\API文档\\Java Platform SE 8.chm").length());
        File file1 = new File("C:\\Users\\yxz\\Desktop\\课件笔记源码资料\\4_文档资料\\API");
        System.out.println(file1.exists());
        //先判断是否存在
        // file1.isDirectory()  file1.isFile()
        if (file1.exists()) {
            System.out.println(file1.isDirectory());
            System.out.println(file1.isFile());
        }
    }

    public static void test1() {
        //1、new File(".")构建的是当前目录的路径
        File path = new File(".");
        String[] list = path.list();
        for (String itemName : list) {
            System.out.println(itemName);
        }
        //2、new File("E:\\Java")利用绝对路径构建E盘下的Java目录路径
        System.out.println("--------->");
        path = new File("E:\\Java");
        list = path.list();
        for (String itemName : list) {
            System.out.println(itemName);
        }
        //3、new File(new File("."),"bin")表示当前目录下的bin目录
        System.out.println("--------->");
        path = new File(new File("."), "bin");
        list = path.list();//列出bin目录下的所有文件或者是文件夹
        for (String itemName : list) {
            System.out.println(itemName);
        }

    }
}

