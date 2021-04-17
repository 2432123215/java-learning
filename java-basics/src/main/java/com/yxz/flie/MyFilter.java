package com.yxz.flie;

import java.io.File;
import java.io.FileFilter;

/**
 * @ClassName: MyFilter
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/4/14
 * @Version 1.0
 **/
public class MyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().endsWith(".java");
    }
}
