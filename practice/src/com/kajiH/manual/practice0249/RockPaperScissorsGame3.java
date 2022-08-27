package com.kajiH.manual.practice0249;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame3 {
    private static final String[] HAND_TYPES = { "グー", "チョキ", "パー" };

    private static final String WORD_THAT_LETS_PLAY_ROCK_PAPER_SCISSORS = "じゃんけん勝負\n";
    private static final String WORD_THAT_SELECT_MENU = "%d : %s\n";
    private static final String WORD_THAT_ROCK_PAPPER_SCISSORS = "最初はグー、じゃんけん：";
    private static final String WORD_THAT_PLAYERS_CHOICE = "%s（COM）と %s（Player）で...\n";
    private static final String WORD_THAT_AIKO = "あいこで：";
    private static final String WORD_THAT_WIN = "あなたの勝ち\n";
    private static final String WORD_THAT_LOSE = "あなたの負け\n";
    private static final String BLANK_LINE = "\n";

    private static final String WORD_THAT_PLEASE_INPUT_NUM = "数字を入力してください\n";
    private static final String WORD_THAT_PLEASE_INPUT_IN_RANGE = "%d ~ %d の範囲で入力してください\n";

    private static Random RAND = new Random();
    private static Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        showExplanation();

        boolean isWin = playGame();

        showResult(isWin);
    }

    // ゲームの説明
    private static void showExplanation() {
        show(WORD_THAT_LETS_PLAY_ROCK_PAPER_SCISSORS);
        showSelectMenuOf(HAND_TYPES);
        show(BLANK_LINE);
    }

    private static void show(String word) {
        System.out.printf(word);
    }

    private static void showSelectMenuOf(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(WORD_THAT_SELECT_MENU, i, array[i]);
        }
    }

    // じゃんけん
    private static boolean playGame() {

        show(WORD_THAT_ROCK_PAPPER_SCISSORS);

        int myChoice = selectMyChoiceIn(HAND_TYPES);
        int enemyChoice = selectRandomChoiceIn(HAND_TYPES);

        showWordThatPlayersChoiceIn(HAND_TYPES, myChoice, enemyChoice);

        while (isAiko(myChoice, enemyChoice)) {
            show(WORD_THAT_AIKO);

            myChoice = selectMyChoiceIn(HAND_TYPES);
            enemyChoice = selectRandomChoiceIn(HAND_TYPES);

            showWordThatPlayersChoiceIn(HAND_TYPES, myChoice, enemyChoice);
        }

        return isMyWin(myChoice, enemyChoice);
    }

    private static void showWordThatPlayersChoiceIn(String[] array,
            int myChoice, int enemyChoice) {
        System.out.printf(WORD_THAT_PLAYERS_CHOICE, array[enemyChoice],
                array[myChoice]);
    }

    private static int selectMyChoiceIn(String[] array) {
        String inputStr = STDIN.nextLine();

        int inputInt = validate(inputStr, array);

        return inputInt;
    }

    private static int validate(String inputStr, String[] array) {
        if (!isInteger(inputStr)) {
            show(WORD_THAT_PLEASE_INPUT_NUM);
            return selectMyChoiceIn(array);
        }

        int inputInt = Integer.parseInt(inputStr);

        if (!isRangeOf(array, inputInt)) {
            showWordThatPleaseInputInRangeOf(array);
            return selectMyChoiceIn(array);
        }

        return inputInt;
    }

    private static void showWordThatPleaseInputInRangeOf(String[] array) {
        System.out.printf(WORD_THAT_PLEASE_INPUT_IN_RANGE, 0, array.length - 1);
    }

    private static boolean isRangeOf(String[] array, int inputInt) {
        return inputInt >= 0 && inputInt < array.length;
    }

    private static boolean isInteger(String inputStr) {
        try {
            Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int selectRandomChoiceIn(String[] array) {
        return RAND.nextInt(array.length);
    }

    private static boolean isMyWin(int myChoice, int enemyChoice) {
        return (myChoice + 1) % 3 == enemyChoice;
    }

    private static boolean isAiko(int myChoice, int enemyChoice) {
        return myChoice == enemyChoice;
    }

    // 勝敗を表示
    private static void showResult(boolean isWin) {
        if (isWin) {
            show(WORD_THAT_WIN);
            return;
        }

        show(WORD_THAT_LOSE);
    }
}
