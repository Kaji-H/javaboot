package com.kajiH.Intermediate.practice03.practice0301;

import java.util.ArrayList;
import java.util.List;

public class DogOwner {

    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();

        dogList.add(new Dog("秋田賢", 7, "秋田犬"));
        dogList.add(new Dog("山本一郎", 1, "プードル"));
        dogList.add(new Dog("山田太郎", 2, "チワワ"));

        for (Dog dog : dogList) {
            dog.showDetails();
        }
    }
}