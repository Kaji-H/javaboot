package com.kajih.practice04.entity;

public class Rabbit extends Animal {

    public Rabbit(String name, boolean isMale) {
        super(name, isMale, HERBIVORE);
    }

    @Override
    public void bark() {
        System.out.printf("みゅー　みゅー .......\n");
    }

    @Override
    public void eat() {
        System.out.printf("%s は %s .........草を食べた.....\n",
                this.name, this.eatHabit);
    }

}
