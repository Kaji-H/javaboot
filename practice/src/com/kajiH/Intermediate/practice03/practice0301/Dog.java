package com.kajiH.Intermediate.practice03.practice0301;

public class Dog {

    private String name;
    private int age;
    private String dogType;

    public Dog(String name, int age, String dogType) {
        this.name = name;
        this.age = age;
        this.dogType = dogType;
    }

    public void showDetails() {
        System.out.printf("%s の %s は %d 歳です.\n", this.dogType, this.name, this.age);
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getDogType() {
        return this.dogType;
    }

}
