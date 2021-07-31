package com.kajiH.manual.practice0249;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame4 {
    private static final String[] HAND_TYPES = { "グー", "チョキ", "パー" };
    private static final String[] DIRECTION_TYPES = { "上", "下", "左", "右" };
    private static final int CHALLENGE_TIMES = 3;
    private static final int FIRST_ROUND = 1;

    private static final String WORD_THAT_LETS_PLAY_ROCK_PAPER_SCISSORS = "じゃんけん勝負\n";
    private static final String WORD_THAT_SELECT_MENU = "%d : %s\n";
    private static final String WORD_THAT_ROUND = "%d 回戦目\n";
    private static final String WORD_THAT_ROCK_PAPPER_SCISSORS = "最初はグー、じゃんけん：";
    private static final String WORD_THAT_PLAYERS_CHOICE = "%s（%s）と %s（%s）で...\n";
    private static final String WORD_THAT_AIKO = "あいこで：";

    private static final String WORD_THAT_LETS_LOOK_THAT_WAY = "あっち向いてホイ\n";
    private static final String WORD_THAT_LOOK_THAT_WAY = "%s : あっち向いて...\n";

    private static final String WORD_THAT_WIN = "あなたの勝ち\n";
    private static final String WORD_THAT_LOSE = "あなたの負け\n";
    private static final String BLANK_LINE = "\n";
    private static final String WORD_THAT_LAST_RESULT = "最終結果 :　%d 勝　%d 敗\n";

    private static final String WORD_THAT_PLEASE_INPUT_NUM = "数字を入力してください\n";
    private static final String WORD_THAT_PLEASE_INPUT_IN_RANGE = "%d ~ %d の範囲で入力してください\n";

    private static Random RAND = new Random();
    private static Scanner STDIN = new Scanner(System.in);

    private static String myName = "Player";
    private static String enemyName = "CP";

    public static void main(String[] args) {
        int round = FIRST_ROUND;
        int countWinNum = 0;

        show(WORD_THAT_LETS_PLAY_ROCK_PAPER_SCISSORS);
        show(WORD_THAT_LETS_LOOK_THAT_WAY);
        showSelectMenuOf(HAND_TYPES);
        showSelectMenuOf(DIRECTION_TYPES);

        while (isOverChallengeTimes(round)) {
            showWordThatRound(round);

            boolean isWin = playLookThatWayGame();

            showResult(isWin);

            if (isWin) {
                countWinNum++;
            }

            round++;
        }

        showLastResult(countWinNum);
    }

    private static boolean isOverChallengeTimes(int round) {
        return round <= CHALLENGE_TIMES;
    }

    private static void show(String word) {
        System.out.printf(word);
    }

    private static void showSelectMenuOf(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(WORD_THAT_SELECT_MENU, i, array[i]);
        }
        show(BLANK_LINE);
    }

    private static void showWordThatRound(int round) {
        System.out.printf(WORD_THAT_ROUND, round);
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
                enemyName, array[myChoice], myName);
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

    // あっち向いてホイ
    private static boolean playLookThatWayGame() {
        boolean isWin = playGame();
        showResult(isWin);

        showWordThatLookThatWay(isWin);

        int myChoice = selectMyChoiceIn(DIRECTION_TYPES);
        int enemyChoice = selectRandomChoiceIn(DIRECTION_TYPES);

        showWordThatPlayersChoiceIn(DIRECTION_TYPES, myChoice, enemyChoice);

        if (isWin) {
            return attackResult(myChoice, enemyChoice);
        }
        return defengResult(myChoice, enemyChoice);
    }

    private static void showWordThatLookThatWay(boolean isWin) {
        String name = myName;

        if (!isWin) {
            name = enemyName;
        }

        System.out.printf(WORD_THAT_LOOK_THAT_WAY, name);
    }

    private static boolean attackResult(int myChoice, int enemyChoice) {

        if (!isSameDirection(myChoice, enemyChoice)) {
            return playLookThatWayGame();
        }
        return true;
    }

    private static boolean defengResult(int myChoice, int enemyChoice) {

        if (!isSameDirection(myChoice, enemyChoice)) {
            return playLookThatWayGame();
        }
        return false;
    }

    private static boolean isSameDirection(int myChoice, int enemyChoice) {
        return myChoice == enemyChoice;
    }

    // 勝敗を表示
    private static void showResult(boolean isWin) {
        if (isWin) {
            show(WORD_THAT_WIN);
            show(BLANK_LINE);
            return;
        }

        show(WORD_THAT_LOSE);
        show(BLANK_LINE);
    }

    private static void showLastResult(int winNum) {
        int loseNum = CHALLENGE_TIMES - winNum;
        System.out.printf(WORD_THAT_LAST_RESULT, winNum, loseNum);
    }
}
