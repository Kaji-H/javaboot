package com.kajiH.manual.practice0216;

import java.util.Scanner;

/**
 * StringInputReceiver
 */
public class StringInputReceiver {

    public static void main(String[] args) {
        String line;

        Scanner sc = new Scanner(System.in);

        System.out.println("文字列を入力してください：");
        line = sc.nextLine();

        System.out.println("入力された名前は" + line + "です。");

        sc.close();
    }
}