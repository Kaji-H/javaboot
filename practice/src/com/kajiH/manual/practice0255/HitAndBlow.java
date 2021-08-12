package com.kajiH.manual.practice0255;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HitAndBlow {
    // int[] -> String[] にしたほうがよい 最初が0の場合があるため

    private static final int[] NUM_LIST_FOR_SET = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static final int MAX_ANSWER_NUM = 4;
    private static final int GIVE_HINT_FOR_EVERY_NUM = 3;
    private static final int MAX_NUM_OF_RESPONSE = 10;

    private static final String MESSAGE_THAT_HINT = "ヒント %d 番目の数字は %d だよ\n";
    private static final String MESSAGE_THAT_GAME_CLEAR = "おめでとう！ %d 回目で成功♪\n";
    private static final String MESSAGE_THAT_GAME_OVER = "残念、失敗\n";

    private static Random RAND = new Random();
    private static Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        int[] ansNum = new int[MAX_ANSWER_NUM];
        int count = 1;

        setNumber(ansNum);

        while (count <= MAX_NUM_OF_RESPONSE) {

            if (count % GIVE_HINT_FOR_EVERY_NUM == 0) {
                showHint(ansNum, count);
            }

            playHitAndBlow(ansNum);

            count++;
        }

        showResult(count);
    }

    private static void setNumber(int[] ansNum) {
        List<Integer> numListArray = getNumList();

        for (int i = 0; i < MAX_ANSWER_NUM; i++) {
            int elements = RAND.nextInt(numListArray.size());
            ansNum[i] = numListArray.get(elements);

            numListArray.remove(elements);
        }

    }

    private static List<Integer> getNumList() {
        List<Integer> list = new ArrayList<>();

        for (int num : NUM_LIST_FOR_SET) {
            list.add(num);
        }
        return list;
    }

    private static void playHitAndBlow(int[] ansNum) {
        showMessageThatRequestToInputNum();
        int[] inputNum = inputNumArray();

        int hit = countHit(ansNum, inputNum);

        if (hit == MAX_ANSWER_NUM) {
            return;
        }

        int blow = countBlow(ansNum, inputNum);

        showHitAndBlow(hit, blow);
    }

    private static void showHitAndBlow(int hit, int blow) {
    }

    private static int countBlow(int[] ansNum, int[] inputNum) {
        return 0;
    }

    private static int countHit(int[] ansNum, int[] inputNum) {
        return 0;
    }

    private static int[] inputNumArray() {
        String inputStr = STDIN.nextLine();

        if (!isInteger(inputStr)) {
            return inputNumArray();
        }

        int inputNum = Integer.parseInt(inputStr);

        if (!isAnsNumRange(inputNum)) {
            return inputNumArray();
        }

        int[] inputNumArray = changeArray(inputNum);

        return inputNumArray;
    }

    private static int[] changeArray(int inputNum) {
        List<Integer> list = new ArrayList<>();

        while (inputNum <= 0) {

            list.add(inputNum % 10);
            inputNum = inputNum / 10;
        }

        return null;
    }

    private static boolean isAnsNumRange(int inputNum) {
        int digitCount = 0;
        while (inputNum <= 0) {
            inputNum = inputNum / 10;
            digitCount++;
        }

        if (digitCount == MAX_ANSWER_NUM)
            ;
        return false;
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private static void showMessageThatRequestToInputNum() {
    }

    private static void showHint(int[] ansNum, int count) {
        int hintTimes = count / GIVE_HINT_FOR_EVERY_NUM;

        System.out.printf(MESSAGE_THAT_HINT, hintTimes, ansNum[hintTimes]);
    }

    private static void showResult(int count) {
        if (count < MAX_NUM_OF_RESPONSE) {
            System.out.printf(MESSAGE_THAT_GAME_CLEAR, count);
        }

        System.out.printf(MESSAGE_THAT_GAME_OVER);
    }

}
