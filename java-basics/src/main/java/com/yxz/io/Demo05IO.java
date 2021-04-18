package com.yxz.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @ClassName: Demo05IO
 * @Description: porperties的学习
 * @Author: yangxiangzhong
 * @Date 2021/4/18
 * @Version 1.0
 **/
public class Demo05IO {
    public static void main(String[] args) throws IOException {
        showporperties();
    }

    private static void showporperties() throws IOException {

        Properties properties = new Properties();
        properties.setProperty("张三","45");
        properties.setProperty("历史","99");
        properties.setProperty("舒徐","56+");
        properties.setProperty("隐喻","77");
        Set<String> strings = properties.stringPropertyNames();
        for (String s :strings){
            String property = properties.getProperty(s);
            System.out.println(s+property);
        }
        FileWriter fileWriter = new FileWriter("java-basics\\properties.properties");
        properties.store(fileWriter,"备注");
        fileWriter.close();
        FileReader fileReader = new FileReader("java-basics\\properties.properties");
        properties.load(fileReader);
        fileReader.close();
        Set<String> strings1 = properties.stringPropertyNames();
        for (String s : strings1) {
            String property = properties.getProperty(s);
            System.out.println(s+property);
        }

    }
}
