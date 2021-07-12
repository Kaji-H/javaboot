package com.kajiH.practice02447;

import java.util.Random;
import java.util.Scanner;

public class GuessCardGame2 {

    private static final String[] CARD_MARK = { "ハート", "ダイヤ", "スペード", "クローバ" };
    private static final int[] CARD_NUMBER = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13 };
    private static final String[] CARD_NUMBER_STRING = { "A", "J", "Q", "K" };
    private static final int MAX_MARK_NUM = CARD_MARK.length - 1;
    private static final int MIN_MARK_NUM = 0;
    private static final int MAX_CARD_NUM = CARD_NUMBER.length;
    private static final int MIN_CARD_NUM = 1;
    private static final int CHALENGE_TIMES_FOR_NUMBER_SELECTION = 4;
    private static final int CHALENGE_TIMES_FOR_MARK_SELECTION = 2;

    // トランプを選ぶ処理のワード
    private static final String WORDS_THAT_CHOICE_CARD = "トランプを選択しました。\n";
    // トランプの図柄を当てる処理のワード
    private static final String WORDS_THAT_PLEASE_SELECT_MARK = "トランプの図柄を当ててね\n";
    private static final String WORDS_THAT_CHOICE = "%d : %s\n";
    private static final String WORDS_THAT_CLEAR_MARK_GAME = "正解!図柄は%sだよ\n";
    private static final String WORDS_THAT_MISS_MARK = "%sじゃないよ\n";
    private static final String WORDS_THAT_PLEASE_INPUT_NUMBER = "数字を入力してください\n";
    private static final String WORDS_THAT_PLEASE_INPUT_IN_MARK_RANGE = "%d ~ %d の間で選択してください\n";
    // トランプの数字を当てる処理のワード
    private static final String WORDS_THAT_PLEASE＿SELECT_NUMBER = "次は数字を当ててね\n";
    private static final String WORDS_THAT_MISS_NUMBER = "%dじゃないよ\n";
    private static final String WORDS_THAT_PLEASE_INPUT_CARD_NUMBER = "トランプの番号を選択してください\n";
    private static final String PLEASE_INPUT_IN_CARD_NUMBER_RANGE = "%d ~ %d の間で選択してください\n";
    private static final String WORDS_THAT_HINT = "%s数字だよ\n";
    private static final String BIGGER = "大きい";
    private static final String SMALLER = "小さい";
    // トランプ当てゲームの結果の処理のワード
    private static final String WORDS_THAT_CLEAR = "正解！%sの%dだよ！\n";
    private static final String WORDS_THAT_MISS = "残念！%sの%dだよ\n";

    private static Random RANDOM = new Random();
    private static Scanner STDIN = new Scanner(System.in);

    private static int correctMarkElements;
    private static int correctNumberElements;

    public static void main(String[] args) {
        selectCorrectCard();

        boolean isClear = guessMarkGame();

        if (isClear) {
            isClear = guessNumberGame();
        }

        result(isClear);
    }

    private static void selectCorrectCard() {
        correctMarkElements = RANDOM.nextInt(CARD_MARK.length);
        correctNumberElements = RANDOM.nextInt(CARD_NUMBER.length);

        System.out.printf(WORDS_THAT_CHOICE_CARD);
    }

    // トランプの図柄を当てる処理
    private static boolean guessMarkGame() {
        int count = 0;

        showWordsThatSelectMark();
        showWordsThatChoice();

        while (!isOverChalengeTimesForMark(count)) {
            int markNumber = inputMarkNumber();

            if (isCorrectMark(markNumber)) {
                showWordsThatClearMarkGame();
                return true;
            }

            showWordsThatMissMark(markNumber);
            count++;
        }
        return false;
    }

    private static void showWordsThatMissMark(int markNumber) {
        System.out.printf(WORDS_THAT_MISS_MARK, CARD_MARK[markNumber]);
    }

    private static void showWordsThatClearMarkGame() {
        System.out.printf(WORDS_THAT_CLEAR_MARK_GAME,
                CARD_MARK[correctMarkElements]);
    }

    private static boolean isOverChalengeTimesForMark(int count) {
        return count > CHALENGE_TIMES_FOR_MARK_SELECTION;
    }

    private static boolean isCorrectMark(int markNumber) {
        return markNumber == correctMarkElements;
    }

    private static int inputMarkNumber() {
        String inputStr = STDIN.nextLine();

        if (!isInteger(inputStr)) {
            showWordsThatPleaseInputNumber();
            return inputMarkNumber();
        }

        int input = changeStringToInteger(inputStr);

        if (!isInMarkRange(input)) {
            showWordsThatPleaseInputInMarkRange(MAX_MARK_NUM, MIN_MARK_NUM);
            return inputMarkNumber();
        }

        return input;
    }

    private static void showWordsThatPleaseInputInMarkRange(int maxNum,
            int minNum) {
        System.out.printf(WORDS_THAT_PLEASE_INPUT_IN_MARK_RANGE, minNum,
                maxNum);
    }

    private static void showWordsThatPleaseInputNumber() {
        System.out.printf(WORDS_THAT_PLEASE_INPUT_NUMBER);
    }

    private static boolean isInMarkRange(int input) {
        return input >= 0 && input < CARD_MARK.length;
    }

    private static int changeStringToInteger(String inputStr) {
        return Integer.parseInt(inputStr);
    }

    private static boolean isInteger(String inputStr) {
        try {
            Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static void showWordsThatSelectMark() {
        System.out.printf(WORDS_THAT_PLEASE_SELECT_MARK);

    }

    private static void showWordsThatChoice() {
        for (int i = 0; i < CARD_MARK.length; i++) {
            System.out.printf(WORDS_THAT_CHOICE, i, CARD_MARK[i]);
        }
    }

    // トランプの数字を当てる処理
    private static boolean guessNumberGame() {
        int count = 0;

        showWordsThatSelectNumber();

        while (!isOverChalengeTimesForNumber(count)) {
            int number = inputNumber();

            if (isCorrectNumber(number)) {
                return true;
            }
            count++;

            showWordsThatMissNumber(number);
            showWordsThatHint(number);
        }
        return false;
    }

    private static void showWordsThatHint(int number) {
        System.out.printf(WORDS_THAT_HINT,
                (number < CARD_NUMBER[correctNumberElements] ? BIGGER
                        : SMALLER));
    }

    private static void showWordsThatMissNumber(int number) {
        System.out.printf(WORDS_THAT_MISS_NUMBER, number);
    }

    private static boolean isOverChalengeTimesForNumber(int count) {
        return count > CHALENGE_TIMES_FOR_NUMBER_SELECTION;
    }

    private static boolean isCorrectNumber(int number) {
        return number == CARD_NUMBER[correctNumberElements];
    }

    private static int inputNumber() {
        String inputStr = STDIN.nextLine();

        if (!isCardNumber(inputStr)) {
            showWordsThatPleaseInputCardNumber();
            return inputNumber();
        }

        int input = changeStringToCardNumber(inputStr);

        if (!isInCardNumberRange(input)) {
            showWordsThatPleaseInputInCardNumberRange(MAX_CARD_NUM,
                    MIN_CARD_NUM);
            return inputNumber();
        }

        return input;
    }

    private static int changeStringToCardNumber(String inputStr) {
        int inputNum;

        try {
            inputNum = Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            inputNum = changeCardNumber(inputStr);
        }

        return inputNum;
    }

    private static void showWordsThatPleaseInputInCardNumberRange(int maxNum,
            int minNum) {
        System.out.printf(PLEASE_INPUT_IN_CARD_NUMBER_RANGE, minNum, maxNum);
    }

    private static void showWordsThatPleaseInputCardNumber() {
        System.out.printf(WORDS_THAT_PLEASE_INPUT_CARD_NUMBER);
    }

    private static int changeCardNumber(String inputStr) {
        if (inputStr.equals(CARD_NUMBER_STRING[0])) {
            return 1;
        }

        if (inputStr.equals(CARD_NUMBER_STRING[1])) {
            return 11;
        }

        if (inputStr.equals(CARD_NUMBER_STRING[2])) {
            return 12;
        }

        return 13;

    }

    private static boolean isInCardNumberRange(int input) {
        return input >= MIN_CARD_NUM && input <= MAX_CARD_NUM;
    }

    private static boolean isCardNumber(String inputStr) {
        try {
            Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            if (!isCardName(inputStr)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCardName(String inputStr) {
        for (int i = 0; i < CARD_NUMBER_STRING.length; i++) {
            if (CARD_NUMBER_STRING[i].equals(inputStr)) {
                return true;
            }
        }
        return false;
    }

    private static void showWordsThatSelectNumber() {
        System.out.printf(WORDS_THAT_PLEASE＿SELECT_NUMBER);
    }

    // 結果を表示する処理
    private static void result(boolean isClear) {
        if (isClear) {
            showWordsThatClear();
            return;
        }

        showWordsThatMiss();
    }

    private static void showWordsThatMiss() {
        System.out.printf(WORDS_THAT_MISS, CARD_MARK[correctMarkElements],
                CARD_NUMBER[correctNumberElements]);
    }

    private static void showWordsThatClear() {
        System.out.printf(WORDS_THAT_CLEAR, CARD_MARK[correctMarkElements],
                CARD_NUMBER[correctNumberElements]);
    }

}
