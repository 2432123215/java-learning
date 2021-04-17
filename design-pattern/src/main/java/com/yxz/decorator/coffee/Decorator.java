package com.yxz.decorator.coffee;

/**
 * @ClassName: Decorator
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/4/1
 * @Version 1.0
 **/
public class Decorator extends Drink {
    Drink drink;

    public
    Decorator(Drink drink) { //组合
        this.drink = drink;
    }
    @Override
    public float cost() {
        return super.getPrice() + drink.getPrice();
    }


    @Override
    public String getDes() {
        // obj.getDes() 输出被装饰者的信息
        return des + " " + getPrice() + " && " + drink.getDes()+" "+ drink.getPrice();
    }
}
