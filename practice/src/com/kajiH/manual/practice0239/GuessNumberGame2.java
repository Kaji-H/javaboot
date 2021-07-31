package com.kajiH.manual.practice0239;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame2 {

    private final static int RANDOM_RANGE = 100;
    private final static int MAX_CHALLENGE_TIMES = 5;
    private final static Random RANDOM = new Random();
    private final static Scanner STDIN = new Scanner(System.in);

    private final static int[] HINT_LEVEL = { 10, 50, 100, 250, RANDOM_RANGE };
    private final static String[] HINT_LEVEL_MESSAGES = { "ちょっと", "", "もっと",
            "かなり", "とても" };

    private static int challengeCounter = 1;

    public static void main(String[] args) {

        int correctNum = RANDOM.nextInt(RANDOM_RANGE);

        printStart();

        guess(correctNum);

        printResult(correctNum, challengeCounter);

        STDIN.close();
    }

    private static void printStart() {
        System.out.printf("数字を当ててみてね\n");
    }

    private static int guess(int correctNum) {
        int inputNum = 0;

        while (MAX_CHALLENGE_TIMES >= challengeCounter) {

            System.out.printf("%d回目", challengeCounter);

            try {
                inputNum = Integer.parseInt(STDIN.next());

            } catch (NumberFormatException e) {
                System.out.printf("数字を入力してください\n");
                continue;
            }

            if (isMatchInt(correctNum, inputNum)) {
                return challengeCounter;
            }

            printHint(correctNum, inputNum);

            challengeCounter++;
        }
        return challengeCounter;
    }

    private static void printResult(int correctNum, int count) {
        if (isSmallerCountThanMax(count)) {
            System.out.printf("すごい！！%d回で当てられちゃった！\n", count);
        } else {
            System.out.printf("残念！！正解は%dでした！\n", correctNum);
        }
    }

    private static boolean isSmallerCountThanMax(int count) {
        return count < MAX_CHALLENGE_TIMES;
    }

    private static boolean isMatchInt(int num1, int num2) {
        return num1 == num2;
    }

    private static void printHint(int correctNum, int inputNum) {
        int numGap = correctNum - inputNum;
        String numGapMessage = (inputNum > correctNum ? "小さい" : "大きい");

        for (int i = 0; i < HINT_LEVEL.length; i++) {
            if (Math.abs(numGap) <= HINT_LEVEL[i]) {

                System.out.printf("%s%s数字だよ\n", HINT_LEVEL_MESSAGES[i],
                        numGapMessage);
                return;
            }
        }

        return;
    }

}
