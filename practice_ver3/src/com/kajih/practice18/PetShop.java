package com.kajih.practice18;

import com.kajih.practice18.Config.Gender;

public class PetShop {

    public static void main(String[] args) {
        Animal[] pets = {
                new Rabbit(
                        "スキウサギ",
                        Gender.FEMALE),
                new Cat(
                        "どらねこ",
                        Gender.MALE),
        };

        for (Animal pet : pets) {
            System.out.println(pet.toString());
            pet.eat();
            pet.bark();
            System.out.println();
        }

        pets[0].changeName("ツキウサギ");
        System.out.println(pets[0].toString());
        pets[0].eat();
        Barkable rabbit = pets[0];
        rabbit.bark();
    }
}
