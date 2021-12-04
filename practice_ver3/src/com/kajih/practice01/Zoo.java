package com.kajih.practice01;

import com.kajih.practice01.entity.Dog;

public class Zoo {

    public static void main(String[] args) {
        Dog labrador = new Dog();
        labrador.setName("ポチ");
        labrador.display();
        labrador.eat();
    }

}