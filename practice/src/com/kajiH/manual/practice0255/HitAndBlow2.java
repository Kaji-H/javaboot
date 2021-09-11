package com.kajiH.manual.practice0255;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HitAndBlow2 {

    private static final String[] CHOICES = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    private static final int CORRECT_DIGIT = 5;
    private static final int MAX_RESPONSES_NUM = 10;
    private static final int TIMING_OF_HINTS = 3;

    private static final String EMPTY_STR = "";

    private static final String MESSAGE_THAT_HINT = "ヒント  %d 番目の数字は %s です\n";
    private static final String MESSAGE_THAT_ROUND = "-----%d回目-----\n";
    private static final String MESSAGE_THAT_MAKES_CHOICE = "%s さん %d 桁の数字を入力してください。";
    private static final String MESSAGE_THAT_HIT_AND_BLOW_NUM = "ヒット：%d個、ブロー：%d個\n";
    private static final String MESSAGE_THAT_INPUT_NUM_IN_DIGIT_RANGE = "%d 桁の数字を入力してください\n";
    private static final String MESSAGE_THAT_INPUT_NUM = "数字を入力してください";
    private static final String MESSAGE_THAT_GAOME_OVER = "残念！正解は %s だよ\n";
    private static final String MESSAGE_THAT_GAME_CLEAR = "%s さん おめでとう！%d 回目で成功♪\n";

    private static Random rand = new Random();
    private static Scanner stdin = new Scanner(System.in);

    private static String[] players = { "あなた" };

    public static void main(String[] args) {
        String[] correct = makeCorrect();
        String correctStr = changeStrArrayToString(correct);

        int round = 0;
        String winnerName = EMPTY_STR;

        while (isGameFinish(round, winnerName)) {
            round++;
            showRound(round);

            if (isTimingOfHints(round)) {
                showHint(round, correct);
            }

            for (String name : players) {

                showMessageThatMakesChoice(name);
                String[] responses = inputResponseNum();

                if (isSameArray(correct, responses)) {
                    winnerName = name;
                    break;
                }

                int hit = getHitNum(correct, responses);
                int blow = getBlowNum(correct, responses);

                showHitAndBlowNum(hit, blow);
            }
        }

        showResult(round, winnerName, correctStr);
    }

    private static String[] makeCorrect() {
        String[] makingCorrect = new String[CORRECT_DIGIT];
        List<String> tempList = new ArrayList<>(Arrays.asList(CHOICES));

        for (int i = 0; i < CORRECT_DIGIT; i++) {
            int elements = rand.nextInt(tempList.size());

            makingCorrect[i] = tempList.get(elements);
            tempList.remove(elements);
        }

        return makingCorrect;
    }

    private static String changeStrArrayToString(String[] correct) {
        String str = EMPTY_STR;

        for (String numStr : correct) {
            str += numStr;
        }

        return str;
    }

    private static String[] inputResponseNum() {
        String numStr = stdin.nextLine();

        String[] numStrArray = validate(numStr);

        return numStrArray;
    }

    private static String[] validate(String numStr) {
        if (!isInt(numStr)) {
            show(MESSAGE_THAT_INPUT_NUM);
            return inputResponseNum();
        }

        if (!isInDigitRange(numStr.length())) {
            showMessageThatInputNumInDigitRange(CORRECT_DIGIT);
            return inputResponseNum();
        }

        String[] numStrArray = numStr.split(EMPTY_STR);

        return numStrArray;
    }

    private static int getHitNum(String[] correct, String[] responses) {
        int hitCount = 0;

        for (int i = 0; i < CORRECT_DIGIT; i++) {
            if (isSameStrNum(correct[i], responses[i])) {
                hitCount++;
            }
        }

        return hitCount;
    }

    private static int getBlowNum(String[] correct, String[] responses) {
        int blowCount = 0;

        for (int i = 0; i < CORRECT_DIGIT; i++) {
            for (int j = 0; j < CORRECT_DIGIT; j++) {
                if (isHit(i, j)) {
                    continue;
                }

                if (isSameStrNum(correct[j], responses[i])) {
                    blowCount++;
                    break;
                }
            }
        }
        return blowCount;
    }

    private static void show(String message) {
        System.out.printf(message);
    }

    private static void showRound(int round) {
        System.out.printf(MESSAGE_THAT_ROUND, round);
    }

    private static void showHint(int round, String[] correct) {
        int hintNum = round / TIMING_OF_HINTS;
        int correctElements = hintNum - 1;

        System.out.printf(MESSAGE_THAT_HINT, hintNum, correct[correctElements]);
    }

    private static void showMessageThatMakesChoice(String name) {
        System.out.printf(MESSAGE_THAT_MAKES_CHOICE, name, CORRECT_DIGIT);
    }

    private static void showMessageThatInputNumInDigitRange(int digitRange) {
        System.out.printf(MESSAGE_THAT_INPUT_NUM_IN_DIGIT_RANGE, digitRange);
    }

    private static void showHitAndBlowNum(int hit, int blow) {
        System.out.printf(MESSAGE_THAT_HIT_AND_BLOW_NUM, hit, blow);
    }

    private static void showResult(int round, String winnerName, String correct) {
        if (winnerName.isEmpty()) {
            System.out.printf(MESSAGE_THAT_GAOME_OVER, correct);
            return;
        }

        System.out.printf(MESSAGE_THAT_GAME_CLEAR, winnerName, round);
    }

    private static boolean isInDigitRange(int length) {
        return length == CORRECT_DIGIT;
    }

    private static boolean isInt(String numStr) {
        try {
            Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static boolean isHit(int correctElements, int responseElements) {
        return correctElements == responseElements;
    }

    private static boolean isSameStrNum(String correct, String response) {
        return correct.equals(response);
    }

    private static boolean isSameArray(String[] correct, String[] responses) {
        return Arrays.equals(correct, responses);
    }

    private static boolean isTimingOfHints(int round) {
        return round % TIMING_OF_HINTS == 0;
    }

    private static boolean isGameFinish(int round, String winnerName) {
        return round < MAX_RESPONSES_NUM && winnerName.isEmpty();
    }
}
