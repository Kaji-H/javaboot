package com.kajih.practice6;

import com.kajih.practice6.liquid.Coffee;
import com.kajih.practice6.liquid.Milk;

public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeCup myCup = new CoffeeCup();
        Coffee coffee = new Coffee();
        Milk milk = new Milk();
        myCup.addLiquid(coffee);
        myCup.stir();
        System.out.println();
        myCup.addLiquid(milk);
        myCup.stir();
    }
}
