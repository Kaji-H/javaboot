package com.kajih.practice16.practice16_1;

public class Hello2 {
    public void sayHello() {
        Hello hello = new Hello() {
            @Override
            public void sayHello() {
                System.out.println("こんにちはネストした匿名クラス");
            }
        };
        hello.sayHello();
    }
}
