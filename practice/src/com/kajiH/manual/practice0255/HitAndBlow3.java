package com.kajiH.manual.practice0255;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HitAndBlow3 {

    private static final String MESSAGE_THAT_HIT_AND_BLOW_NUM = "ヒット：%d個、ブロー：%d個\n";
    private static final String MESSAGE_THAT_SELECT_ANSWER_NUM = "[%d回目 %s] %d 桁の数字を入力してください:";
    private static final String MESSAGE_THAT_HINT = "ヒント：%d番目の数字は %c です\n";
    private static final String MESSAGE_THAT_INPUT_SAME_NUM_AS_DIGIT = "%d 桁の数字を入力してください\n";
    private static final String MESSAGE_THAT_INPUT_NUM = "数字を入力してください";
    private static final String MESSAGE_THAT_GAME_OVER = "残念！正解は %s だよ\n";
    private static final String MESSAGE_THAT_GAME_CLEAR = "%s おめでとう!! %d回目で成功♪\n";

    private static final String[] CHOICES = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    private static final int CORRECT_DIGIT = 4;
    private static final int BASIC_CHALLENGE_TIMES = 10;
    private static final int BASIC_INTERVAL_OF_HINTS = 3;

    private static final String[] playerNames = { "あなた" };
    private static final int playerNum = playerNames.length;
    private static final int challengeTimes = BASIC_CHALLENGE_TIMES * playerNum;
    private static final int intervalOfHints = BASIC_INTERVAL_OF_HINTS * playerNum;

    private static final int FIRST_COUNT = 1;
    private static final int ONE_LINE = 1;
    private static final String BLANK_STR = "";

    private static final Random RAND = new Random();
    private static final Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        String correctNumStr = generateCorrect();
        int playerSelectCount = FIRST_COUNT;

        while (isInChallengeTimesRange(playerSelectCount)) {

            showMessageThatInputNum(playerSelectCount);
            String answerNumStr = inputAnswer();

            if (isCorrectAnswer(correctNumStr, answerNumStr)) {
                break;
            }

            int hit = countHit(correctNumStr, answerNumStr);
            int blow = countBlow(correctNumStr, answerNumStr);

            showResultCount(hit, blow);

            if (isIntervalOfHints(playerSelectCount)) {
                showHint(playerSelectCount, correctNumStr);
            }

            playerSelectCount++;
        }

        showResult(playerSelectCount, correctNumStr);
    }

    private static String generateCorrect() {
        List<String> tempList = new ArrayList<>(Arrays.asList(CHOICES));
        String correctNumStr = BLANK_STR;

        for (int i = 0; i < CORRECT_DIGIT; i++) {
            int randElements = RAND.nextInt(tempList.size());

            correctNumStr += tempList.get(randElements);

            tempList.remove(randElements);
        }
        return correctNumStr;
    }

    private static String inputAnswer() {
        String answer = STDIN.nextLine();

        answer = validate(answer);

        return answer;
    }

    private static String validate(String answer) {
        if (!isInt(answer)) {
            show(MESSAGE_THAT_INPUT_NUM);
            return inputAnswer();
        }

        if (!isEqualCorrectDigit(answer.length())) {
            showMessageThatInputSameNumAsDigit();
            return inputAnswer();
        }

        return answer;
    }

    private static int countHit(String correctNumStr, String answerNumStr) {
        int hit = 0;

        for (int i = 0; i < CORRECT_DIGIT; i++) {
            if (isEqualChar(correctNumStr.charAt(i), answerNumStr.charAt(i))) {
                hit++;
            }
        }

        return hit;
    }

    private static int countBlow(String correctNumStr, String answerNumStr) {
        int blow = 0;

        for (int i = 0; i < CORRECT_DIGIT; i++) {
            for (int j = 0; j < CORRECT_DIGIT; j++) {
                if (isEqualInt(i, j)) {
                    continue;
                }

                if (isEqualChar(correctNumStr.charAt(i), answerNumStr.charAt(j))) {
                    blow++;
                    break;
                }
            }
        }

        return blow;
    }

    private static void showMessageThatInputNum(int playerSelectCount) {

        String playerName = playerNames[playerSelectCount % playerNum];

        System.out.printf(MESSAGE_THAT_SELECT_ANSWER_NUM, playerSelectCount, playerName, CORRECT_DIGIT);
    }

    private static void showMessageThatInputSameNumAsDigit() {
        System.out.printf(MESSAGE_THAT_INPUT_SAME_NUM_AS_DIGIT, CORRECT_DIGIT);
    }

    private static void show(String message) {
        System.out.printf(message);
    }

    private static void showResultCount(int hit, int blow) {

        System.out.printf(MESSAGE_THAT_HIT_AND_BLOW_NUM, hit, blow);
    }

    private static void showHint(int playerSelectCount, String correctNumStr) {

        int digit = playerSelectCount / intervalOfHints;

        if (!isInCorrectDigit(digit)) {
            return;
        }

        int charElements = digit - 1;
        char correctNumChar = correctNumStr.charAt(charElements);

        showBlankLine(ONE_LINE);
        System.out.printf(MESSAGE_THAT_HINT, digit, correctNumChar);
    }

    private static void showBlankLine(int line) {
        for (int i = 0; i < line; i++) {
            System.out.println();
        }
    }

    private static void showResult(int playerSelectCount, String correctNumStr) {

        if (!isInChallengeTimesRange(playerSelectCount)) {
            System.out.printf(MESSAGE_THAT_GAME_OVER, correctNumStr);
            return;
        }

        String playerName = playerNames[playerSelectCount % playerNum];
        int round = playerSelectCount / playerNum;

        System.out.printf(MESSAGE_THAT_GAME_CLEAR, playerName, round);
    }

    private static boolean isInt(String answer) {
        try {
            Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static boolean isEqualCorrectDigit(int digit) {
        return CORRECT_DIGIT == digit;
    }

    private static boolean isInCorrectDigit(int digit) {
        return CORRECT_DIGIT >= digit;
    }

    private static boolean isInChallengeTimesRange(int playerSelectCount) {
        return challengeTimes >= playerSelectCount;
    }

    private static boolean isCorrectAnswer(String correctNumStr, String answerNumStr) {
        return correctNumStr.equals(answerNumStr);
    }

    private static boolean isIntervalOfHints(int playerSelectCount) {
        return playerSelectCount % intervalOfHints == 0;
    }

    private static boolean isEqualChar(char charAt, char charAt2) {
        return charAt == charAt2;
    }

    private static boolean isEqualInt(int num, int num2) {
        return num == num2;
    }
}
