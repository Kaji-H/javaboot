package com.kajih.practice16.practice16_2;

public class AnonymousWithConstructorExample {

    public static void main(String[] args) {
        Hello hello = new Hello("山本一郎") {
            @Override
            public void sayHello() {
                System.out.printf("こんにちは匿名クラスの %s さん\n", this.name);
            }
        };
        hello.sayHello();

    }
}
