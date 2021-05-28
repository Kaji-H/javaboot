package com.kajiH.practice0223;

public class NamePrintMessageBuilder {
    public static void main(String[] args) {
        String name = "山本一郎";
        String message = String.format("僕の名前は %s です。\n", name);

        System.out.printf(message);
    }
}
