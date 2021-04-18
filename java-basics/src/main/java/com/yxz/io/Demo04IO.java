package com.yxz.io;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName: Demo04IO
 * @Description: 字符输出流
 * @Author: yangxiangzhong
 * @Date 2021/4/18
 * @Version 1.0
 **/
public class Demo04IO {
    public static void main(String[] args) throws IOException {
        showWrite();
//        showRead();

    }

    private static void showRead() throws IOException {
//        FileReader fileReader = new FileReader("java-basics\\filewrite.txt");
        File file = new File("java-basics\\filewrite.txt");
        FileReader fileReader = new FileReader(file);
        int len=0;
        while ((len = fileReader.read()) != -1) {
            System.out.print((char) len);
        }
        char[] chars = new char[1024];
        while ((len=fileReader.read(chars))!=-1){
            System.out.println(len);
            System.out.println(new String(chars,0,len));
        }
        fileReader.close();
    }

    private static void showWrite()  {
//        FileWriter fileWriter = new FileWriter("java-basics\\filewrite.txt");
        FileWriter fileWriter =null;
        try {
            fileWriter = new FileWriter(new File("java-basics\\filewrite.txt"),true);
            //写单个字节
            fileWriter.write(88);
            //写string
            fileWriter.write("你好啊");
            //这里用flush来刷新字节，使其进入文件中，但是不关闭流
            fileWriter.flush();
            fileWriter.write("你好啊");
            for(int i =0;i<10 ;i++){
                //\r\n 是换行
                fileWriter.write("你好啊"+i+"\r\n");
            }
        }catch (IOException e){
            System.out.println(e);
        }finally {
            if(fileWriter!=null){
                try {
                    //这里自动调用flush ，并关闭流
                    fileWriter.close();
                }catch (IOException e){
                    System.out.println(e);
                }
            }

        }


    }
}
