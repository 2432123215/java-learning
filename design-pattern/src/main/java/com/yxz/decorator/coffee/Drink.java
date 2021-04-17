package com.yxz.decorator.coffee;

/**
 * @ClassName: Drink
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/4/1
 * @Version 1.0
 **/
public abstract class Drink {
    public String des;
    private float price;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
