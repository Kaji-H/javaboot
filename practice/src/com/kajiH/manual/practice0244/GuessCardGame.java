package com.kajiH.manual.practice0244;

import java.util.Random;
import java.util.Scanner;

public class GuessCardGame {

    private static final String[] CARD_MARK = { "ハート", "ダイヤ", "スペード", "クローバ" };
    private static final int[] CARD_NUMBER = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13 };
    private static final String[] CARD_NUMBER_STRING = { "A", "J", "Q", "K" };

    private static final int CHALENGE_TIMES_FOR_NUMBER_SELECTION = 4;
    private static final int CHALENGE_TIMES_FOR_MARK_SELECTION = 2;

    private static final Random RANDOM = new Random();
    private static final Scanner STDIN = new Scanner(System.in);

    private static boolean isNotCorrect = false;

    public static void main(String[] args) {
        int correctMarkElement = RANDOM.nextInt(CARD_MARK.length);
        int correctNumberElement = RANDOM.nextInt(CARD_NUMBER.length);

        playSelectMark(correctMarkElement);

        if (!isNotCorrect) {
            playSelectNumber(correctNumberElement);
        }

        endResult(correctMarkElement, correctNumberElement);

        STDIN.close();
    }

    private static void playSelectMark(int correctMarkElement) {
        int answerCounter = 0;

        printMarkChoices();

        while (answerCounter < CHALENGE_TIMES_FOR_MARK_SELECTION) {
            int inputNum = 0;

            try {
                inputNum = Integer.parseInt(STDIN.next());

            } catch (NumberFormatException e) {
                System.out.printf("数値を入力してください\n");
                continue;
            }

            if (!isMarkRange(inputNum)) {
                System.out.printf("%d~%dの値を入力してください\n", 0,
                        (CARD_MARK.length - 1));
                continue;
            }

            if (isCorrect(correctMarkElement, inputNum)) {
                System.out.printf("正解！図柄は%sだよ\n",
                        CARD_MARK[correctMarkElement]);
                return;
            }

            System.out.printf("残念！%sではないよ\n", CARD_MARK[inputNum]);
            answerCounter++;
        }

        isNotCorrect = true;
    }

    private static boolean isCorrect(int correct, int inputNum) {
        return correct == inputNum;
    }

    private static boolean isMarkRange(int inputNum) {
        return inputNum >= 0 && inputNum < CARD_MARK.length;
    }

    private static void printMarkChoices() {
        System.out.printf("トランプの図柄を当ててね\n");

        for (int i = 0; i < CARD_MARK.length; i++) {
            System.out.printf("%d:%s\n", i, CARD_MARK[i]);
        }

    }

    private static void playSelectNumber(int correctNumberElement) {
        int answerCounter = 0;

        printRecuestForNumberChoice();

        while (answerCounter < CHALENGE_TIMES_FOR_NUMBER_SELECTION) {
            String inputString = "";
            int inputNum = 0;

            inputString = STDIN.next();

            try {
                inputNum = Integer.parseInt(inputString);

            } catch (NumberFormatException e) {
                if (!isContainsInCardNumberString(inputString)) {
                    System.out.printf("数値を入力してください\n");
                    continue;
                }
                inputNum = changeCardNumber(inputString);
            }

            if (!isNumberRange(inputNum)) {
                System.out.printf("%d~%dの値を入力してください\n", 1, CARD_NUMBER.length);
                continue;
            }

            if (isCorrect(correctNumberElement + 1, inputNum)) {

                break;
            }

            printHint(correctNumberElement + 1, inputNum);
            answerCounter++;
        }

        isNotCorrect = true;
    }

    private static void printHint(int correctNumber, int inputNum) {
        int diff = correctNumber - inputNum;

        System.out.printf("%s数字だよ\n", (diff >= 0 ? "大きい" : "小さい"));
    }

    private static boolean isNumberRange(int inputNum) {
        return inputNum > 0 && inputNum <= CARD_NUMBER.length;
    }

    private static int changeCardNumber(String inputString) {
        if (inputString.equals(CARD_NUMBER_STRING[0])) {
            return 1;
        }

        if (inputString.equals(CARD_NUMBER_STRING[1])) {
            return 11;
        }

        if (inputString.equals(CARD_NUMBER_STRING[2])) {
            return 12;
        }

        return 13;
    }

    private static boolean isContainsInCardNumberString(String inputString) {
        for (int i = 0; i < CARD_NUMBER_STRING.length; i++) {
            if (inputString.equals(CARD_NUMBER_STRING[i])) {
                return true;
            }
        }

        return false;
    }

    private static void printRecuestForNumberChoice() {
        System.out.printf("次は数字を当ててね\n");
    }

    private static void endResult(int correctMarkElement,
            int correctNumberElement) {
        System.out.printf("%s！", (isNotCorrect ? "残念" : "正解"));

        System.out.printf("答えは%sの%dだよ\n", CARD_MARK[correctMarkElement],
                CARD_NUMBER[correctNumberElement]);
    }

}
