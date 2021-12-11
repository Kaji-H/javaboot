package com.kajih.practice6;

import com.kajih.practice6.liquid.Liquid;

public class CoffeeCup {

    private String liquid;

    public void addLiquid(Liquid liquid) {
        this.liquid = liquid.getName();
    }

    public void stir() {
        System.out.printf("中身の%sをかき混ぜる\n", this.liquid);
    }
}
