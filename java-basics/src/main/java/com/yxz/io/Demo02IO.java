package com.yxz.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName: Demo02IO
 * @Description: 文件复制
 * @Author: yangxiangzhong
 * @Date 2021/4/17
 * @Version 1.0
 **/
public class Demo02IO {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("java-basics\\java8.chm");

        /*
        注意点就是FileOutputStream是不会自动建文件夹的
        * */
        File file = new File("D:\\BaiduNetdiskDownload\\java8.chm");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        long l = System.currentTimeMillis();
        int len=0;
        //耗时较多
//        while ((len=fileInputStream.read())!=-1){
//            fileOutputStream.write(len);
//        }
        byte[] bytes = new byte[1024];
        while ((len=fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        long l1 = System.currentTimeMillis();
        long l2 = (l1 - l) / 1000;
        System.out.println("耗时"+l2+"秒");
        fileOutputStream.close();
        fileInputStream.close();
    }
}
