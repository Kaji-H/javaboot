package com.kajiH.practice0230;

public class LeapYearChecker {
    public static void main(String[] args) {
        LeapYearAnswer(-45);
        LeapYearAnswer(356);
        LeapYearAnswer(1700);
        LeapYearAnswer(2300);
        LeapYearAnswer(2596);
    }

    private static void LeapYearAnswer(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                System.out.println("西暦 " + year + " 年はうるう年です。");
                return;
            }

            if (year % 400 == 0) {
                System.out.println("西暦 " + year + " 年はうるう年です。");
                return;
            }
        }

        System.out.println("西暦 " + year + " 年はうるう年ではありません。");
    }
}
