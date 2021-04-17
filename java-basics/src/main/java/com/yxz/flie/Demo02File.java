package com.yxz.flie;

import java.io.File;
import java.io.IOException;

/**
 * @author yxz
 * @create 2021-04-13 13:47
 */
public class Demo02File {
    public static void main(String[] args) throws IOException {
//        newfiletest();
        creatdir();
    }

    public static void newfiletest() throws IOException {
        File file = new File("D:\\java-learning\\java-basics\\a.txt");
        //只创建文件
        boolean newFile = file.createNewFile();
        System.out.println(newFile);
        //路径不存在
        File file1 = new File("java-basics1\\b");
        System.out.println(file1);
        boolean newFile1 = file1.createNewFile();
        System.out.println(newFile1);
    }

    public static void creatdir() throws IOException {
        //mkdir() 创建单级文件夹
        //mkdirs()创建多级级文件夹
        File file = new File("D:\\java-learning\\java-basics\\cc");


        //只创建文件夹
        boolean newFile = file.mkdir();
        System.out.println(newFile);
        //路径不存在  报false
        File file1 = new File("java-basics1\\22");
        System.out.println(file1);
        boolean newFile1 = file1.mkdir();
        System.out.println(newFile1);
        //只创建文件夹
        File ff = new File("D:\\java-learning\\java-basics\\c.txt");
        boolean f = ff.mkdir();
        System.out.println(f);
    }
}
