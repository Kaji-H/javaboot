package com.kajiH.manual.practice0255;

import java.util.Random;
import java.util.Scanner;

public class HitAndBlow3 {

    String[] CHOICES = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
    int CORRECT_DIGIT = 4;
    int CHALLENGE_TIMES = 10;
    int INTERVAL_OF_HINTS = 3;
    Random RAND = new Random();
    Scanner STDIN = new Scanner(System.in);

    String[] playerName = { "あなた" };

    public static void main(String[] args) {
        String[] correct = generateCorrect();
        int round = 0;

        while (isOverChallengeTimes(round)) {
            showRound(round);

            for (String name : playerName) {
                showMessageThatPleaseSelectNum(name);
            }
        }
    }
}
