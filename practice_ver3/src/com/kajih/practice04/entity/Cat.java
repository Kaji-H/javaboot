package com.kajih.practice04.entity;

public class Cat extends Animal {

    public Cat(String name, boolean gender) {
        super(name, gender, CARNIVORE);
    }

    @Override
    public void bark() {
        System.out.printf("にゃあ　にゃあ .......\n");
    }

    @Override
    public void eat() {
        System.out.printf("%s は %s .........魚を食べた.....\n",
                this.name, this.eatHabit);

    }

    public void test() {
    }

}
