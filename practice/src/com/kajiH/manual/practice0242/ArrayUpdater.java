package com.kajiH.manual.practice0242;

public class ArrayUpdater {
    public static void main(String[] args) {
        int[] numList = { 1, 2, 3, 4, 5 };

        updateArray(numList);

        for (int num : numList) {
            System.out.println(num);
        }
    }

    private static void updateArray(int[] num) {
        int halfArrayNum = num.length / 2;
        int maxArrayNum = num.length - 1;

        for (int i = 0; i <= halfArrayNum; i++) {
            int temp = num[i];
            num[i] = num[maxArrayNum - i];
            num[maxArrayNum - i] = temp;
        }
    }
}
