package com.yxz.io;



import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName: Demo03IO
 * @Description: 字节流的弊端
 * @Author: yangxiangzhong
 * @Date 2021/4/18
 * @Version 1.0
 **/
public class Demo03IO {
    public static void main(String[] args) throws IOException {
//        show();
        show1();
    }

    /**
     * 出现乱码 这是单个字节转换
     * @throws IOException
     */
    private static void show1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("java-basics\\5.txt");
        int len=0;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
            System.out.println( len);
        }
        fileInputStream.close();

    }

    /**
     * 不出现乱码
     * @throws IOException
     */
    private static void show() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("java-basics\\5.txt");
        int len=0;
        while ((len = fileInputStream.read()) != -1) {
            System.out.println((char) len);
        }
        fileInputStream.close();

    }
}
