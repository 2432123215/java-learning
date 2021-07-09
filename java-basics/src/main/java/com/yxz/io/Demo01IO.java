package com.yxz.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName: Demo03IO
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/4/15
 * @Version 1.0
 **/
public class Demo01IO {
    public static void main(String[] args) throws IOException {
//        System.out.println("outputStreamshow()-------------------------------------------");
//        outputStreamshow();
//
//        System.out.println("inputStreamshow()-------------------------------------------");
//        inputStreamshow();

        System.out.println("inputStreamshow2()-------------------------------------------");
        inputStreamshow2();

        System.out.println("inputStreamshow3()-------------------------------------------");
        inputStreamshow3();

    }

    /**
     * 字节流的输出
     *
     * @throws IOException outputStream
     */
    private static void outputStreamshow() throws IOException {
        //1.创建流
        FileOutputStream file = new FileOutputStream("E:\\workspace\\workspace-idea\\java-learning\\java-basics\\a.txt");
        FileOutputStream fileOut = new FileOutputStream("b.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("java-basics\\C.txt");
        FileOutputStream fileOutputStream2 = new FileOutputStream("java-basics\\5.txt", true);
        //2.write 放写入
        /*
        write(int b)
        将指定的字节写入此文件输出流。
        并且是自动拼接
        */
        fileOutputStream2.write(52);
        fileOutputStream2.write(52);
        fileOutputStream2.write(96);
        fileOutputStream2.write(65);
        /*
        write(byte[] b, int off, int len)
        将 len字节从位于偏移量 off的指定字节数组写入此文件输出流。
        */
        fileOutputStream.write("ABCD".getBytes(), 2, 2);
        /*
        write(byte[] b)
        将 b.length个字节从指定的字节数组写入此文件输出流。
        */
        byte[] bytes = "你好".getBytes();
        System.out.println(Arrays.toString(bytes));

        fileOut.write(bytes);

        //写入流
        //write(int b)
        //将指定的字节写入此文件输出流。
        file.write(55);

        //3.关闭流
        file.close();
        fileOutputStream.close();
        fileOutputStream2.close();
        fileOut.close();

    }

    /**
     * 一次性读取一个字节
     *
     * @throws IOException
     */
    private static void inputStreamshow() throws IOException {
        //1.创建流
        FileInputStream fileInputStream = new FileInputStream("java-basics\\C.txt");
        FileInputStream fileInputStream2 = new FileInputStream("b.txt");

        //2.read的方法进行读取
        int read = 0;
//        read= fileInputStream.read();
//        System.out.println(read);
//        read= fileInputStream.read();
//        System.out.println(read);
//        read= fileInputStream.read();
//        System.out.println(read);
//        read= fileInputStream.read();
//        System.out.println(read);
//
      /* // 这样写有问题，他有个默认的指标 每读取一次，下标向后移动 所以会间隔读取
      while (fileInputStream.read()!=-1){
            System.out.println(fileInputStream.read());
          System.out.println((char) fileInputStream.read());
        }*/
        while ((read = fileInputStream.read()) != -1) {
            System.out.println(read);
            System.out.println((char) read);
        }
//        int read1 = 0;
//        while ((read1=fileInputStream2.read(new byte[5]))!=-1){
//            System.out.println(read);
//        }

        //3.释放资源
        fileInputStream.close();
        fileInputStream2.close();
    }

    /**
     * 一次性读取多个字节
     *
     * @throws IOException
     */
    private static void inputStreamshow2() throws IOException {
        //1.创建流
        FileInputStream fileOutputStream = new FileInputStream("java-basics\\C.txt");
        FileInputStream fileOutputStream2 = new FileInputStream("java-basics\\5.txt");

        //2.使用read的方法进行读取
        //数组的作用是缓冲 的，其每一次读取的都是一个字节，但是数组可以缓存两个
        //一般把数组定义成1024（1kb）或者是整数倍
        byte[] bytes = new byte[4];
        int read;
        read = fileOutputStream.read(bytes);
        //结果： 4  这是读取的长度和上面的不一样
        System.out.println(read);
        //结果： [67, 68, 101, 114]
        System.out.println(Arrays.toString(bytes));
        /*
        String(byte[] bytes)
        通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
        String(byte[] bytes, Charset charset)
        构造一个新的String由指定用指定的字节的数组解码charset
        String(byte[] bytes, int offset, int length)
        通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。
         */
        System.out.println(new String(bytes));
        //在此读取
        read = fileOutputStream.read(bytes);
        System.out.println(read);
        System.out.println(new String(bytes));
        //在此读取
        read = fileOutputStream.read(bytes);
        System.out.println(read);
        System.out.println(new String(bytes));

        while ((read = fileOutputStream2.read(bytes)) != -1) {
            System.out.println(read);
            System.out.println(new String(bytes));
        }
        //3.流关闭
        fileOutputStream.close();
        fileOutputStream2.close();

    }

    private static void inputStreamshow3() throws IOException {
        //1.创建流
        FileInputStream fileOutputStream2 = new FileInputStream("java-basics\\C.txt");

        //2.使用read的方法进行读取
        //数组的作用是缓冲 的，其每一次读取的都是一个字节，但是数组可以缓存两个
        //一般把数组定义成1024（1kb）或者是整数倍
        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = fileOutputStream2.read(bytes)) != -1) {
            System.out.println(read);
            //这个打印的好处是有多少打印多少，不会出行空格
            System.out.println(new String(bytes, 0, read));
            //这个打印会出现多个空格 应为是1024 字节
            // System.out.println(new String(bytes));
        }
        //3.流关闭
        fileOutputStream2.close();

    }
}
