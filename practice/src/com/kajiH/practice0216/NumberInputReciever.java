package com.kajiH.practice0216;

import java.util.Scanner;

/**
 * NumberInputReciever
 */
public class NumberInputReciever {

    public static void main(String[] args) {
        int value;

        Scanner sc = new Scanner(System.in);

        System.out.printf("数字を入力してください：");

        value = sc.nextInt();

        System.out.printf("入力された数字は %d です。\n", value);

        sc.close();
    }
}