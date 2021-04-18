package com.yxz.io;


import java.io.*;

/**
 * @ClassName: Demo06IO
 * @Description: 字节缓冲流
 * @Author: yangxiangzhong
 * @Date 2021/4/18
 * @Version 1.0
 **/
public class Demo06IO {
    public static void main(String[] args) throws IOException {
//        showoutput();
        showinput();
    }

    private static void showinput() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("java-basics\\buffer.tet");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        int len =0;
//        while (( len= bufferedInputStream.read())!=-1){
//            System.out.println((char)len);
//        }
        byte[] bytes = new byte[1024];
        while (( len= bufferedInputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
            System.out.println(len);
        }
        bufferedInputStream.close();
    }

    private static void showoutput()  {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //1.创建字节流
            FileOutputStream fileOutputStream = new FileOutputStream("java-basics\\buffer.tet");
            //2.创建缓冲流
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //3.用bufferstream的writer
            for(int i= 0;i<10;i++){
                bufferedOutputStream.write(("你好啊\r\n").getBytes());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream!=null) {
                try {
                    //4.用flush吧缓存数据，刷新到文件中
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
