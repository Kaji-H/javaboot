package com.kajih.practice03;

public class NullPointerDemo {
    public static void main(String args[]) {
        try {
            generateNullPointerDemo();
        } catch (NullPointerException e) {
            System.out.format("再キャッチ: %s %n", e);
        }
    }

    static void generateNullPointerDemo() {
        System.out.println("generateNullPointerDemo の中でキャッチされた");
        throw new NullPointerException("demo");
    }
}
