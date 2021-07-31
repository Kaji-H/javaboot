package com.kajiH.manual.practice0239;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    private static final int GAME_LEVEL = 3;
    private static final int RANDOM_RANGE = (int) Math.pow(10, GAME_LEVEL);
    private static final int MAX_CHALLENGE_TIMES = 5 * GAME_LEVEL;
    private static final Random RANDOM = new Random();
    private static final Scanner STDIN = new Scanner(System.in);

    private static final int[] HINT_LEVEL = { 10, 50, 100, 250, RANDOM_RANGE };
    private static final String[] HINT_LEVEL_MESSAGES = { "ちょっと", "", "もっと",
            "かなり", "とても" };

    public static void main(String[] args) {

        int correctNum = RANDOM.nextInt(RANDOM_RANGE);
        int challengeCounter = 1;

        printStart();

        while (!isOverMaxChallengeTime(challengeCounter)) {
            int inputNum = 0;
            showTryCount(challengeCounter);

            try {
                inputNum = Integer.parseInt(STDIN.next());

            } catch (NumberFormatException e) {
                showReguireInputNumber();
                continue;
            }

            if (!isCorrectRange(inputNum)) {
                showAttentionInputRange();
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

    private static void showAttentionInputRange() {
        System.out.printf("0~%dの数字を入力してください\n", RANDOM_RANGE - 1);
    }

    private static boolean isCorrectRange(int inputNum) {
        return inputNum < RANDOM_RANGE && inputNum >= 0;
    }

    private static void showTryCount(int challengeCounter) {
        System.out.printf("%d回目", challengeCounter);
    }

    private static void showReguireInputNumber() {
        System.out.printf("数字を入力してください\n");
    }

    private static void printStart() {
        System.out.printf("数字を当ててみてね\n");
    }

    private static void printResult(int correctNum, int count) {
        if (!isOverMaxChallengeTime(count)) {
            System.out.printf("すごい！！%d回で当てられちゃった！\n", count);
            return;
        }

        System.out.printf("残念！！正解は%dでした！\n", correctNum);

    }

    private static boolean isOverMaxChallengeTime(int count) {
        return count > MAX_CHALLENGE_TIMES;
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
