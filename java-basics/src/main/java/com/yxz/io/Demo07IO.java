package com.yxz.io;

import java.io.*;

/**
 * @ClassName: Demo07IO
 * @Description: 字符缓冲流
 * @Author: yangxiangzhong
 * @Date 2021/4/18
 * @Version 1.0
 **/
public class Demo07IO {
    public static void main(String[] args) throws IOException {
//        showout();
        showin();
    }

    private static void showin() throws IOException {
        FileReader fileReader = new FileReader("java-basics\\bufferwriter.tet");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int len=0;
        char[] chars = new char[1024];
        while ((len=bufferedReader.read(chars))!=-1) {
            System.out.print(new String(chars,0,len));
        }
//        while ((len=bufferedReader.read())!=-1) {
//            System.out.print((char)len);
//        }
//        String line=null;
//        while ((line=bufferedReader.readLine())!=null) {
//            System.out.println(line);
//        }
        bufferedReader.close();
    }

    private static void showout() throws IOException {
        FileWriter fileWriter = new FileWriter("java-basics\\bufferwriter.tet");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(int i=0;i<10;i++){
//            bufferedWriter.write("数据缓冲流\r\n");
            bufferedWriter.write("数据缓冲流");
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
