package com.kajiH.Intermediate.practice05.practice0501;

public class Adder {

    public void showResultAdded(int a, int b) {
        int sum = add(a, b);
        System.out.printf("%d + %d = %d\n", a, b, sum);
    }

    private int add(int a, int b) {
        return a + b;
    }

    public void showResultAdded(int[] array) {
        int sum = add(array);
        for (int i = 0; i < array.length; i++) {

            if (isFirstIndex(i)) {
                System.out.printf("%d ", array[i]);
                continue;
            }

            System.out.printf("+ %d ", array[i]);
        }

        System.out.printf("= %d\n", sum);
    }

    private boolean isFirstIndex(int i) {
        return i == 0;
    }

    private int add(int[] array) {
        int sum = 0;

        for (int num : array) {
            sum += num;
        }
        return sum;
    }

}