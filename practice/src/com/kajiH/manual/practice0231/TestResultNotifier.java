package com.kajiH.manual.practice0231;

import java.util.Scanner;

public class TestResultNotifier {

    private final static int PASS_SCORE_MINIT = 70;

    public static void main(String[] args) {
        int score = 0;
        Scanner stdin = new Scanner(System.in);

        System.out.println("100点満点中、難点だったか回答してください。");
        System.out.printf("数学のテストの得点は？：");

        do {
            score = stdin.nextInt();

            if (testScoreRange(score)) {
                System.out.println("100点満点で入力してください。");
            }
        } while (testScoreRange(score));

        String mathTestResult = score >= PASS_SCORE_MINIT ? "合格" : "不合格";

        System.out.printf("数学のテストは %s です。\n", mathTestResult);

        stdin.close();
    }

    private static boolean testScoreRange(int score) {
        return score >= 100 || score <= 0;
    }
}
