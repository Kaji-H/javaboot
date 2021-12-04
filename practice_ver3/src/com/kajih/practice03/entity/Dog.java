package com.kajih.practice03.entity;

public class Dog extends Animal {

    public Dog() {
        super("[Dog] String 引数のコンストラクタを呼び出し");

        System.out.println("[Dog] Animal Dog クラスを生成しました.");

    }

    @Override
    public void bark(String sound) {
        super.bark("わんわん" + sound);
    }
}
