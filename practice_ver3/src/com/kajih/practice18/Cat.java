package com.kajih.practice18;

import com.kajih.practice18.Config.FoodingType;
import com.kajih.practice18.Config.Gender;

public class Cat extends Animal {

    public Cat(String name, Gender gender) {
        super(name, gender, FoodingType.CARNIVORE);
    }

    @Override
    public void bark() {
        System.out.println("にゃあ にゃあ ........");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("魚を食べた ........");
    }
}
