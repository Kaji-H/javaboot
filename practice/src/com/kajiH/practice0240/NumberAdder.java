package com.kajiH.practice0240;

public class NumberAdder {
    public static void main(String[] args) {
        int orangeNum = 25;
        int appleNum = 15;

        System.out.printf("みかん： %d 個\n", orangeNum);
        System.out.printf("りんご： %d 個\n", appleNum);

        NumberAdder practice = new NumberAdder();

        int result = practice.addNumbers(orangeNum, appleNum);

        System.out.printf("合計： %d 個\n", result);
    }

    public int addNumbers(int num1, int num2) {
        return num1 + num2;
    }

}
