package com.kajih.practice13_2;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

    private final Config.Message MESSAGE = new Config().new Message();

    private List<Integer> scoreList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();

    private int maxDigit = 0;
    private int maxCharacters = 0;

    public void entryScore(int score, String name) {

        setMaxDigit(score);
        setMaxCharacters(name);

        for (int i = 0; i < this.scoreList.size(); i++) {
            if (this.scoreList.get(i) < score) {
                this.scoreList.add(i, score);
                this.nameList.add(i, name);
                return;
            }
        }

        this.scoreList.add(score);
        this.nameList.add(name);
    }

    public void printRanking() {
        for (int i = 0; i < this.scoreList.size(); i++) {
            System.out.printf(MESSAGE.RANK, i + 1);

            printName(nameList.get(i));
            printScore(scoreList.get(i));

            System.out.println();
        }
    }

    private void setMaxCharacters(String name) {
        maxCharacters = maxCharacters < name.length() ? name.length() : maxCharacters;
    }

    private void setMaxDigit(int score) {
        int digit = generateDigit(score);
        maxDigit = maxDigit < digit ? digit : maxDigit;
    }

    private void printName(String name) {
        int blankNum = maxCharacters - name.length();

        while (needsBlank(blankNum)) {
            System.out.printf(MESSAGE.BLANK);
            blankNum--;
        }

        System.out.printf(MESSAGE.NAME, name);
    }

    private void printScore(int score) {
        int blankNum = maxDigit - generateDigit(score);

        while (needsBlank(blankNum)) {
            System.out.printf(MESSAGE.BLANK);
            blankNum--;
        }

        System.out.printf(MESSAGE.SCORE, score);
    }

    private int generateDigit(int score) {
        return String.valueOf(score).length();
    }

    private boolean needsBlank(int blankNum) {
        return blankNum > 0;
    }

}
