package com.kajiH.Intermediate.practice05.practice0502;

public class Person {

    private String name;
    private int age;

    Person() {
        this("名無しの太郎", 20);
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.printf("%s さんは %d 歳です。\n", this.name, this.age);
    }
}
