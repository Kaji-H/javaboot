package com.kajiH.manual.practice0250;

public class FoolishMethodOwner {
    private final int[] CONFIGURATED_NUMS = { 6, 11, 25, 41, 52, };
    private boolean isLucky = false;

    public static void main(String[] args) {
        FoolishMethodOwner app = new FoolishMethodOwner();
        int numsLength = app.CONFIGURATED_NUMS.length;
        for (int i = 0; i < numsLength; i++) {
            int number = app.getConfiguratedNum(i);
            app.setIsLucky(number);
            app.showIsLucky(number);
        }
    }

    private int getConfiguratedNum(int index) {
        return CONFIGURATED_NUMS[index];
    }

    private void setIsLucky(int num) {
        if (isEvenNum(num)) {
            this.isLucky = true;
            return;
        }

        this.isLucky = false;
    }

    private boolean isEvenNum(int num) {
        return num % 2 == 0;
    }

    private void showIsLucky(int num) {
        if (this.isLucky) {
            System.out.printf("%2d => 幸運です. %n", num);
            return;
        }
        System.out.printf("%2d => 幸運ではありません. %n", num);
    }
}