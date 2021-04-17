package com.yxz.decorator.coffee;

/**
 * @ClassName: Milk
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/4/1
 * @Version 1.0
 **/
public class Milk extends Decorator {

    public Milk(Drink obj) {
        super(obj);
        setDes("牛奶");
        setPrice(2.0f);
    }
}
