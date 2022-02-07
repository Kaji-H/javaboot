package com.kajih.practice16.practice16_1;

public class Main {

    public static void main(String[] args) {
        Hello hello = () -> System.out.println("こんにちは匿名クラス");
        hello.sayHello();

        Hello2 hello2 = new Hello2();
        hello2.sayHello();
    }
}
