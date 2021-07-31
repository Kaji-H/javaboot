package com.kajiH.manual.practice0249;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame1 {
    private static final String[] ROCK_PAPER_SCISSERS_NAME_ARRAY = { "グー",
            "チョキ", "パー" };
    private static final int HAND_NUM = 3;
    private static final int ZERO = 0;

    private static final String WORD_THAT_LETS_PLAY_ROCK_PAPER_SCISSORS = "じゃんけん勝負\n";
    private static final String WORD_THAT_PLEASE_INPUT_ROCK_PAPER_SCISSORS = "グーチョキパーを数字で選択してね\n";
    private static final String WORD_THAT_CHOICE = "%d : %s\n";
    private static final String WORD_THAT_PLAYERS_CHOICE = "%s(COM)と%s(Player)で...\n";
    private static final String WORD_THAT_PLEASE_INPUT_IN_RANGE = "数字を入力してください\n";
    private static final String WORD_THAT_PLEASE_INPUT_NUM = "%d ~ %d の間で入力してください\n";
    private static final String WORD_THAT_WIN = "あなたの勝ちです\n";
    private static final String WORD_THAT_LOSE = "あなたの負けです\n";

    private static Random RAND = new Random();
    private static Scanner STDIN = new Scanner(System.in);
    private static final String WORD_THAT_ONE_TWO_THREE = "あいこです\n";

    public static void main(String[] args) {
        boolean isWin = false;

        showWordThatLetsPlayRockPaperScissors();
        showWordThatRockPaperScissors();

        isWin = playRockPaperScissorsGame();

        result(isWin);
    }

    private static void showWordThatLetsPlayRockPaperScissors() {
        System.out.printf(WORD_THAT_LETS_PLAY_ROCK_PAPER_SCISSORS);
    }

    private static void showWordThatRockPaperScissors() {
        System.out.printf(WORD_THAT_PLEASE_INPUT_ROCK_PAPER_SCISSORS);

        for (int i = 0; i < 3; i++) {
            System.out.printf(WORD_THAT_CHOICE, i,
                    ROCK_PAPER_SCISSERS_NAME_ARRAY[i]);
        }
    }

    private static boolean playRockPaperScissorsGame() {
        int myChoice = selectMyChoice();
        int enemyChoice = selectEnemyChoice();

        showWordThatPlayersChoice(myChoice, enemyChoice);

        return judgeTheWinnerOfRockPaperScissorsGame(myChoice, enemyChoice);

    }

    private static int selectMyChoice() {
        String inputStr = STDIN.nextLine();

        if (!isInteger(inputStr)) {
            showWordThatPleaseInputNum();
            return selectMyChoice();
        }

        int inputInt = Integer.parseInt(inputStr);

        if (!isRange(inputInt)) {
            showWordThatPleaseInputInRange();
            return selectMyChoice();
        }

        return inputInt;
    }

    private static void showWordThatPleaseInputInRange() {
        System.out.printf(WORD_THAT_PLEASE_INPUT_IN_RANGE);
    }

    private static boolean isRange(int inputInt) {
        return inputInt >= ZERO && inputInt < HAND_NUM;
    }

    private static void showWordThatPleaseInputNum() {
        System.out.printf(WORD_THAT_PLEASE_INPUT_NUM, ZERO, HAND_NUM);
    }

    private static boolean isInteger(String inputStr) {
        try {
            Integer.parseInt(inputStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int selectEnemyChoice() {
        return RAND.nextInt(HAND_NUM);
    }

    private static void showWordThatPlayersChoice(int myChoice,
            int enemyChoice) {
        System.out.printf(WORD_THAT_PLAYERS_CHOICE,
                ROCK_PAPER_SCISSERS_NAME_ARRAY[enemyChoice],
                ROCK_PAPER_SCISSERS_NAME_ARRAY[myChoice]);
    }

    private static boolean judgeTheWinnerOfRockPaperScissorsGame(int myChoice,
            int enemyChoice) {

        if (isSameMove(myChoice, enemyChoice)) {
            showWordThatOneTwoThree();
            return playRockPaperScissorsGame();
        }

        if (isMyWin(myChoice, enemyChoice)) {
            return true;
        }

        return false;
    }

    private static void showWordThatOneTwoThree() {
        System.out.printf(WORD_THAT_ONE_TWO_THREE);
    }

    private static boolean isMyWin(int myChoice, int enemyChoice) {
        return (myChoice + 1) % HAND_NUM == enemyChoice;
    }

    private static boolean isSameMove(int myChoice, int enemyChoice) {
        return myChoice == enemyChoice;
    }

    private static void result(boolean isWin) {
        if (isWin) {
            System.out.printf(WORD_THAT_WIN);
            return;
        }
        System.out.printf(WORD_THAT_LOSE);
    }

}
