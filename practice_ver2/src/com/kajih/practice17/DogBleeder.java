package com.kajih.practice17;

public class DogBleeder {

    public static void main(String[] args) {
        Dog akita = new Dog("秋田賢", 7, "秋田犬");
        Dog pudle = new Dog("山本一郎", 1, "プードル");
        Dog chiwawa = new Dog("山本太郎", 2, "チワワ");

        akita.showDetails();
        pudle.showDetails();
        chiwawa.showDetails();
    }
}
