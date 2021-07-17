package com.kajiH.practice0249;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame2 {
    private static final String[] ROCK_PAPER_SCISSERS_NAME_ARRAY = { "グー",
            "チョキ", "パー" };
    private static final String[] DIRECTIONS_NAME_ARRAY = { "上", "下", "左",
            "右" };
    private static final int CHALLENGE_TIMES = 3;
    private static final int FIRST_ROUND = 1;
    private static final int ROCK_PAPER_SCISSERS_NUM = 3;
    private static final int DIRECTIONS_NUM = 4;
    private static final int ZERO = 0;

    private static final String WORD_THAT_LETS_PLAY_ROCK_PAPER_SCISSORS = "じゃんけん勝負\n";
    private static final String WORD_THAT_PLEASE_INPUT_ROCK_PAPER_SCISSORS = "グーチョキパーを数字で選択してね\n";
    private static final String WORD_THAT_CHOICE = "%d : %s\n";
    private static final String WORD_THAT_ROUND = "\n%d回戦目\n";
    private static final String WORD_THAT_PLAYERS_CHOICE = "%s(COM)と%s(Player)で...\n";
    private static final String WORD_THAT_PLEASE_INPUT_IN_RANGE = "%d ~ %d の間で入力してください\n";
    private static final String WORD_THAT_PLEASE_INPUT_NUM = "数字を入力してください\n";
    private static final String WORD_THAT_ONE_TWO_THREE = "あいこです\n";
    private static final String WORD_THAT_LOOK_THAT_WAY = "あっち向いて...";

    private static final String WORD_THAT_WIN = "あなたの勝ちです\n";
    private static final String WORD_THAT_LOSE = "あなたの負けです\n";
    private static final String WORD_THAT_LAST_RESULT = "最終結果は...　%d勝　%d敗　です\n";

    private static Random RAND = new Random();
    private static Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        int count = FIRST_ROUND;
        int numOfTimesWon = ZERO;
        boolean isWin = false;

        showWordThatLetsPlayRockPaperScissors();

        while (!isOverChallengeTime(count)) {

            showWordThatRound(count);
            showWordThatRockPaperScissors();
            showWordThatRockPaperScissorsChoice();

            // isWin = playRockPaperScissorsGame()
            isWin = playLookThatWay();

            showResult(isWin);

            numOfTimesWon += plusOneIf(isWin);
            count++;
        }

        showLastResult(numOfTimesWon);
    }

    private static boolean playLookThatWay() {

        boolean isWinInRockPaperScissors = playRockPaperScissorsGame();

        showResult(isWinInRockPaperScissors);
        showWordThatLookThatWay();
        showWordThatDirectionsChoice();

        int mySelect = selectMyDirection();
        int enemySelect = selectEnemyDirection();

        if (isWinInRockPaperScissors) {
            return attackResult(mySelect, enemySelect);
        }

        return defendResult(mySelect, enemySelect);
    }

    private static int selectEnemyDirection() {
        return RAND.nextInt(DIRECTIONS_NUM);
    }

    private static int selectMyDirection() {
        String inputStr = STDIN.nextLine();

        if (!isInteger(inputStr)) {
            showWordThatPleaseInputNum();
            return selectMyDirection();
        }

        int inputInt = Integer.parseInt(inputStr);

        if (!isRangeOf(DIRECTIONS_NUM, inputInt)) {
            showWordThatPleaseInputInRangeOf(DIRECTIONS_NUM);
            return selectMyDirection();
        }

        return inputInt;
    }

    private static void showWordThatDirectionsChoice() {
        for (int i = 0; i < DIRECTIONS_NUM; i++) {
            System.out.printf(WORD_THAT_CHOICE, i, DIRECTIONS_NAME_ARRAY[i]);
        }
    }

    private static void showWordThatLookThatWay() {
        System.out.printf(WORD_THAT_LOOK_THAT_WAY);
    }

    private static boolean attackResult(int mySelect, int enemySelect) {
        if (mySelect == enemySelect) {
            return playLookThatWay();
        }

        return true;
    }

    private static boolean defendResult(int mySelect, int enemySelect) {
        if (mySelect == enemySelect) {
            return playLookThatWay();
        }

        return false;
    }

    private static void showLastResult(int numOfTimesWon) {
        System.out.printf(WORD_THAT_LAST_RESULT, numOfTimesWon,
                (CHALLENGE_TIMES - numOfTimesWon));
    }

    private static int plusOneIf(boolean isWin) {
        return isWin ? 1 : 0;
    }

    private static boolean isOverChallengeTime(int count) {
        return count > CHALLENGE_TIMES;
    }

    private static void showWordThatRound(int count) {
        System.out.printf(WORD_THAT_ROUND, count);
    }

    private static void showWordThatLetsPlayRockPaperScissors() {
        System.out.printf(WORD_THAT_LETS_PLAY_ROCK_PAPER_SCISSORS);
    }

    private static void showWordThatRockPaperScissors() {
        System.out.printf(WORD_THAT_PLEASE_INPUT_ROCK_PAPER_SCISSORS);

    }

    private static void showWordThatRockPaperScissorsChoice() {
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

        if (!isRangeOf(ROCK_PAPER_SCISSERS_NUM, inputInt)) {
            showWordThatPleaseInputInRangeOf(ROCK_PAPER_SCISSERS_NUM);
            return selectMyChoice();
        }

        return inputInt;
    }

    private static void showWordThatPleaseInputInRangeOf(int maxNum) {
        System.out.printf(WORD_THAT_PLEASE_INPUT_IN_RANGE, ZERO, maxNum);
    }

    private static boolean isRangeOf(int maxNum, int inputInt) {
        return inputInt >= ZERO && inputInt < maxNum;
    }

    private static void showWordThatPleaseInputNum() {
        System.out.printf(WORD_THAT_PLEASE_INPUT_NUM);
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
        return RAND.nextInt(ROCK_PAPER_SCISSERS_NUM);
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
        return (myChoice + 1) % ROCK_PAPER_SCISSERS_NUM == enemyChoice;
    }

    private static boolean isSameMove(int myChoice, int enemyChoice) {
        return myChoice == enemyChoice;
    }

    private static void showResult(boolean isWin) {
        if (isWin) {
            System.out.printf(WORD_THAT_WIN);
            return;
        }
        System.out.printf(WORD_THAT_LOSE);
    }

}
