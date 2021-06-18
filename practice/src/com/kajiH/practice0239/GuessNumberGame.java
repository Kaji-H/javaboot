package com.kajiH.practice0239;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    private final static int RANDOM_RANGE = 100;
    private final static int MAX_CHALLENGE_TIMES = 5;
    private final static Random RANDOM = new Random();
    private final static Scanner STDIN = new Scanner(System.in);

    private final static int[] HINT_LEVEL = { 10, 50, 100, 250, RANDOM_RANGE };
    private final static String[] HINT_LEVEL_MESSAGES = { "ちょっと", "", "もっと",
            "かなり", "とても" };

    public static void main(String[] args) {

        int correctNum = RANDOM.nextInt(RANDOM_RANGE);
        int challengeCounter = 1;

        printStart();

        while (isNotOverMaxChallengeTime(challengeCounter)) {
            int inputNum = 0;
            System.out.printf("%d回目", challengeCounter);

            try {
                inputNum = Integer.parseInt(STDIN.next());

            } catch (NumberFormatException e) {
                System.out.printf("数字を入力してください\n");
                continue;
            }

            if (isCorrect(correctNum, inputNum)) {
                break;
            }

            printHint(correctNum, inputNum);
            challengeCounter++;
        }

        printResult(correctNum, challengeCounter);

        STDIN.close();
    }

    private static void printStart() {
        System.out.printf("数字を当ててみてね\n");
    }

    private static void printResult(int correctNum, int count) {
        if (isNotOverMaxChallengeTime(count)) {
            System.out.printf("すごい！！%d回で当てられちゃった！\n", count);
        } else {
            System.out.printf("残念！！正解は%dでした！\n", correctNum);
        }
    }

    private static boolean isNotOverMaxChallengeTime(int count) {
        return count < MAX_CHALLENGE_TIMES;
    }

    private static boolean isCorrect(int correctNum, int inputNum) {
        return correctNum == inputNum;
    }

    private static void printHint(int correctNum, int inputNum) {
        int diff = correctNum - inputNum;
        String sizeMessage = (inputNum > correctNum ? "小さい" : "大きい");

        for (int i = 0; i < HINT_LEVEL.length; i++) {
            if (isInHintLevel(diff, i)) {

                System.out.printf("%s%s数字だよ\n", HINT_LEVEL_MESSAGES[i],
                        sizeMessage);
                return;
            }
        }
        return;
    }

    private static boolean isInHintLevel(int diff, int i) {
        return Math.abs(diff) <= HINT_LEVEL[i];
    }

}
