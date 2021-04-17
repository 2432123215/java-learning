package com.yxz.decorator.coffee;

/**
 * @ClassName: Coffee
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/4/1
 * @Version 1.0
 **/
public class Coffee extends Drink{
    @Override
    public float cost() {
        return getPrice();
    }
}
