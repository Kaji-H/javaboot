package com.kajiH.practice0239;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    private final static int RANDOM_RANGE = 100;
    private final static int MAX_COUNT = 5;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner stdin = new Scanner(System.in);

        int correctNum = rand.nextInt(RANDOM_RANGE);
        int inputNum = 0;
        int count = 1;

        System.out.printf("数字を当ててみてね%d\n", correctNum);

        for (int i = 1; i <= MAX_COUNT; i++) {
            count = i;

            try {
                System.out.printf("%d回目", i);
                inputNum = Integer.parseInt(stdin.next());

            } catch (NumberFormatException e) {
                System.out.printf("数字を入力してください\n");
                continue;
            }

            if (isMatchInt(correctNum, inputNum)) {
                break;
            }

            getNumHint(correctNum, inputNum);
        }

        showResult(correctNum, count);

        stdin.close();
    }

    private static void showResult(int correctNum, int count) {
        if (isSmallerCountThanMax(count)) {
            System.out.printf("すごい！！%d回で当てられちゃった！\n", count);
        } else {
            System.out.printf("残念！！正解は%dでした！\n", correctNum);
        }
    }

    private static boolean isSmallerCountThanMax(int count) {
        return count < MAX_COUNT;
    }

    private static boolean isMatchInt(int num1, int num2) {
        return num1 == num2;
    }

    private static void getNumHint(int correctNum, int inputNum) {
        System.out.printf("もっと%s数字だよ\n",
                (inputNum > correctNum ? "小さい" : "大きい"));
    }
}
