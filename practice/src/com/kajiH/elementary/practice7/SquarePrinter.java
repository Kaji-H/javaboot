package com.kajiH.elementary.practice7;

import java.util.Scanner;

public class SquarePrinter {

    private static Scanner stdin = new Scanner(System.in);
    private static final int MAX_WIDTH = 9;

    public static void main(String[] args) {
        String strCharInput = inputSingleChar();

        char charToDraw = strCharInput.charAt(0);

        int intWidth = inputWidthOfMaxWidth();

        printSquare(charToDraw, intWidth);

        stdin.close();
    }

    private static int inputWidthOfMaxWidth() {

        System.out.printf("幅（1 ～ %d）を入力してください: ", MAX_WIDTH);

        String strWidthInput = stdin.nextLine();

        int intWidth = validator(strWidthInput);

        System.out.println();

        return intWidth;
    }

    private static int validator(String strWidthInput) {
        int intWidth;

        try {
            intWidth = Integer.parseInt(strWidthInput);
        } catch (NumberFormatException e) {
            showNotWidthValid();
            System.out.println();
            return inputWidthOfMaxWidth();
        }

        if (isWidthValid(intWidth)) {
            showNotWidthValid();
            System.out.println();
            return inputWidthOfMaxWidth();
        }

        return intWidth;
    }

    private static boolean isWidthValid(int intWidth) {
        return intWidth <= 0 || intWidth > MAX_WIDTH;
    }

    private static void printSquare(char charToDraw, int intWidth) {
        for (int i = 0; i < intWidth; i++) {
            for (int j = 0; j < intWidth; j++) {
                System.out.print(charToDraw);
            }
            System.out.println();
        }
    }

    private static void showNotWidthValid() {
        System.out.println(" => 値が不正です.");
    }

    private static String inputSingleChar() {
        String strCharInput;

        System.out.print("一文字入力してください: ");
        strCharInput = stdin.nextLine();

        strCharInput = isInputOneChar(strCharInput);

        // System.out.println();
        return strCharInput;
    }

    private static String isInputOneChar(String strCharInput) {
        if (strCharInput.length() != 1) {
            showNotInputOneChar();
            return inputSingleChar();
        }
        return strCharInput;
    }

    private static void showNotInputOneChar() {
        System.out.println(" => 一文字ではありません.");
    }
}
