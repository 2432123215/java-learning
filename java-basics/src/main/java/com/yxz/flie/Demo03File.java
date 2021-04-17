package com.yxz.flie;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;


/**
 * @ClassName: Demo03File
 * @Description:  递归进行遍历文件
 * @Author: yangxiangzhong
 * @Date 2021/4/14
 * @Version 1.0
 **/
public class Demo03File {

    public static void main(String[] args) {
        File file = new File("java-basics");
//         show(file);
//        showJava(file);
//        showClass(file);
//        showClass2(file);
        showClass3(file);
    }

    /**
     * 打印所有的 文件和目录
     *
     * @param file 文件
     */
    private static void show(File file) {

         //只打印当前目录表小的文件

//        for (String fileName : file.list()) {
//            System.out.println(fileName);
//        }
//        for (File listFile : file.listFiles()) {
//            System.out.println(listFile);
//            System.out.println(listFile.getAbsolutePath());
//        }
        System.out.println(file);
        File[] files = file.listFiles();
        if (files==null){
            return;
        }
        for (File listFile : files) {
            if (listFile.isDirectory()) {
                show(listFile);
            } else {
                System.out.println(listFile);

            }
        }

    }

    /**
     * 打印所有已 .java 结尾的文件
     *
     * @param file
     */
    private static void showJava(File file) {
        for (File listFile : file.listFiles()) {
            if (listFile.isDirectory()) {
                showJava(listFile);
            } else {
                //大小写转化
                String s = listFile.getName().toLowerCase();
                if (s.endsWith(".java")) {
                    System.out.println(listFile);

                }
            }

        }
    }

    private static void showClass(File file) {
        //1.list()方法 ： 会返回一个字符数组，将制定路径下的文件或文件夹名字存储到String数组中
        //2.FilenameFilter filter是一个目录过滤器。list(FilenameFilter filter)方法会选择符合条件的文件或文件夹
        //3.listFiles()方法该路径下所有文件或文件夹的绝对路径（pathname，注意File类型指的是路径，而不是文件）
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                //这里要注意的是的如果是文件夹也要返回true，否则只会取的是当前文件夹下的文件
                if (pathname.isDirectory()) {
                    return true;
                }
                return pathname.getName().endsWith(".class");
            }
        });

        //new MyFilter()是实现FileFilter的class类
        //File[] files = file.listFiles(new MyFilter());
        for (File listFile : files) {
            if(listFile.isDirectory()){
                showClass(listFile);
            }else {
                System.out.println(listFile);
            }
        }

        /**
         * 或者这样写  有问题 既然已经判断是不是文件夹了，那么else 里面就是文件了，在用过滤是不是多此一举,
         * 还有问题是  listFiles()方法该路径下所有文件或文件夹的绝对路径（pathname，注意File类型指的是路径，而不是文件）
         * 这里是文件夹下的，但是文件并没有下属文件所以会 给null
         * 这种写法是错误的
         * listFiles(FileFilter filter)
         * 返回一个抽象路径名数组，表示由此抽象路径名表示的满足指定过滤器的目录中的文件和目录。
         */

//        for (File listFile : file.listFiles()) {
//
//            if (listFile.isDirectory()) {
//                showClass(listFile);
//            } else {
//                FileFilter fileFilter = new FileFilter() {
//                    @Override
//                    public boolean accept(File pathname) {
//                        return pathname.getName().endsWith(".java");
//                    }
//                };
//                File[] files = listFile.listFiles(new MyFilter()) ;
//                if (files != null) {
//                    for (File file1 : files) {
//                        System.out.println(file1);
//
//                    }
//
//                }
//            }
//        }
    }

    /**
     * 文件过滤的改进版，lamda表达式文件这里的file最好是路径，如果不是路径会出问题，
     * file.listFiles是找的是路径下的文件，并不包括当前的本身
     * @param file
     */
    private static void showClass2(File file) {
        if (file.isFile()&&file.getName().toLowerCase().endsWith(".class")) {
            System.out.println(file);
            return;
        }
        File[] files = file.listFiles((pathname) -> {
            if (pathname.isDirectory()) {
                return true;
            }
            return pathname.getName().endsWith(".class");
        });
        for (File listFile : files) {
            if (listFile.isDirectory()) {
                showClass(listFile);
            } else {
                System.out.println(listFile);
            }
        }
    }

    private static void showClass3(File file) {
        if (file.isFile()&&file.getName().toLowerCase().endsWith(".class")) {
            System.out.println(file);
            return;
        }
        File[] files = file.listFiles((pathname,name)
                -> new File(pathname,name).isDirectory()||name.endsWith(".class"));
        /*File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("dir:"+dir +"####"+ "name:"+name );
                return new File(dir,name).isDirectory()||name.endsWith(".class");
            }
        });*/
        for (File listFile : files) {
            if (listFile.isDirectory()) {
                showClass(listFile);
            } else {
                System.out.println(listFile);
            }
        }
    }
}
