package com.yxz.decorator.coffee;

/**
 * @ClassName: CoffeeBar
 * @Description:
 * @Author: yangxiangzhong
 * @Date 2021/4/1
 * @Version 1.0
 **/
public class CoffeeBar {

    public static void main(String[] args) {
        Drink drink = new RedTea();
        drink=new Milk(drink);
        System.out.println("drink.getPrice() = " + drink.cost());
        System.out.println("drink.getDes() = " + drink.getDes());
    }
}
