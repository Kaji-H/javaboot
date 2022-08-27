package com.kajih.practice6;

import com.kajih.practice6.liquid.Liquid;

public class CoffeeCup {

    //private String liquid;
    private Liquid innerLiquid;

    public void addLiquid(Liquid liquid) {
        this.innerLiquid = liquid;
    }

    public void stir() {
        System.out.println("コーヒーカップを持って .....");
        System.out.printf("中身の%sをかき混ぜる\n", this.innerLiquid.getName());
    }
}
