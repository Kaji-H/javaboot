package com.kajiH.manual.practice0216;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BadInputReciever {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("数字を入力してください：");
            num = sc.nextInt();
            System.out.println("数字は" + num + "です。");
        } catch (InputMismatchException e) {
            System.out.println("数値を入力してください。");
        }

        sc.close();

    }
}
