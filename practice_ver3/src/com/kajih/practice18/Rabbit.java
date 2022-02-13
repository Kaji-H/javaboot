package com.kajih.practice18;

import com.kajih.practice18.Config.FoodingType;
import com.kajih.practice18.Config.Gender;

public class Rabbit extends Animal {
    public Rabbit(
            String name, Gender gender) {
        super(name, gender, FoodingType.HERBIVORE);
    }

    @Override
    public void bark() {
        System.out.println("みゅー みゅー ........");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("草を食べた ........");
    }
}
