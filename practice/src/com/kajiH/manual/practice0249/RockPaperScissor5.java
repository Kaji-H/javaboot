package com.kajiH.manual.practice0249;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor5 {
    private static final String[] HANDS_NAME = { "グー", "チョキ", "パー" };
    private static final String[] DIRECTION_NAME = { "上", "下", "左", "右" };
    private static final int FIRST_ROUND = 1;
    private static final int MAX_ROUND = 3;
    private static final int ONE_LINE = 1;
    private static final int COM = 0;
    private static final int USER = 1;

    private static Random RAND = new Random();
    private static Scanner STDIN = new Scanner(System.in);

    private static boolean isFragForFacingOverThere = false;

    public static void main(String[] args) {
        int round = FIRST_ROUND;
        List<Boolean> winHistory = new ArrayList<>();

        explain();

        while (isInMaxRound(round)) {
            showRound(round);

            playJunken(winHistory);

            round++;
        }

        int winCount = getNumOfVictory(winHistory);

        finalResult(winCount);
    }

    private static int getNumOfVictory(List<Boolean> winHistory) {
        int winCount = 0;

        for (boolean win : winHistory) {
            if (win) {
                winCount++;
            }
        }
        return winCount;
    }

    private static void playJunken(List<Boolean> winHistory) {
        show("じゃんけん...:");
        int[] eachHands = getEachHandsWishoutAiko();

        boolean isWinWithJunken = getJankenResult(eachHands);
        showWinOrLose(isWinWithJunken);

        if (isFragForFacingOverThere) {
            show("あっち向いて...：");
            int[] eachDirection = getEachDirection();

            if (!isSameDirection(eachDirection)) {
                playJunken(winHistory);
                return;
            }

            showWinOrLose(isWinWithJunken);
        }
        showBlankLine(ONE_LINE);

        winHistory.add(isWinWithJunken);
        return;
    }

    private static void explain() {
        show("じゃんけん勝負\n");
        showSelectMenu(HANDS_NAME);
        showBlankLine(ONE_LINE);
        if (isFragForFacingOverThere) {
            showSelectMenu(DIRECTION_NAME);
            showBlankLine(ONE_LINE);
        }
    }

    private static void showWinOrLose(boolean isWin) {
        String winOrLose = isWin ? "勝ち" : "負け";

        show("あなたの" + winOrLose);
        showBlankLine(ONE_LINE);
    }

    private static int[] getEachDirection() {
        int comDirection = selectRandomChoiceIn(DIRECTION_NAME);
        int userDirection = selectChoiceIn(DIRECTION_NAME);
        int[] eachDirection = { comDirection, userDirection };
        showWordThatSelected(DIRECTION_NAME, eachDirection);

        return eachDirection;
    }

    private static int[] getEachHandsWishoutAiko() {
        int comHand = selectRandomChoiceIn(HANDS_NAME);
        int userHand = selectChoiceIn(HANDS_NAME);
        int[] eachHands = { comHand, userHand };
        showWordThatSelected(HANDS_NAME, eachHands);

        if (isAiko(eachHands)) {
            show("あいこで...:");
            return getEachHandsWishoutAiko();
        }

        return eachHands;
    }

    private static int selectChoiceIn(String[] array) {
        String input = STDIN.nextLine();

        int choice = validate(input, array);

        return choice;
    }

    private static int validate(String input, String[] array) {
        if (!isInteger(input)) {
            show("数値を入力してください\n");
            return selectChoiceIn(array);
        }

        int choice = Integer.parseInt(input);

        if (!isRangeOf(array, choice)) {
            showRangeOf(array);
            return selectChoiceIn(array);
        }

        return choice;
    }

    private static void showRangeOf(String[] array) {
        int maxRange = array.length - 1;

        System.out.printf("%d ~ %d の範囲で選択してください\n", 0, maxRange);
    }

    private static boolean isRangeOf(String[] array, int choice) {
        return choice >= 0 && choice < array.length;
    }

    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int selectRandomChoiceIn(String[] array) {
        return RAND.nextInt(array.length);
    }

    private static boolean isAiko(int[] eachHands) {
        return eachHands[COM] == eachHands[USER];
    }

    private static boolean isInMaxRound(int round) {
        return round <= MAX_ROUND;
    }

    private static boolean getJankenResult(int[] eachHands) {
        return (eachHands[USER] + 1) % HANDS_NAME.length == eachHands[COM];
    }

    private static boolean isSameDirection(int[] eachDirection) {
        return eachDirection[COM] == eachDirection[USER];
    }

    private static void finalResult(int winCount) {
        System.out.printf("最終結果： %d 勝　%d 敗\n", winCount,
                (MAX_ROUND - winCount));
    }

    private static void showWordThatSelected(String[] array, int[] eachHands) {

        System.out.printf("%s(COM)と%s(Player)で...\n", array[eachHands[COM]],
                array[eachHands[USER]]);
    }

    private static void showRound(int round) {
        System.out.printf("%d回戦目\n", round);
    }

    private static void showBlankLine(int line) {
        for (int i = 0; i < line; i++) {
            System.out.println();
        }
    }

    private static void showSelectMenu(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d:%s\n", i, array[i]);
        }
    }

    private static void show(String message) {
        System.out.printf(message);
    }
}
