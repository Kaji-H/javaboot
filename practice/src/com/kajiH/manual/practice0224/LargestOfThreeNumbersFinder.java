package com.kajiH.manual.practice0224;

import java.util.Scanner;

public class LargestOfThreeNumbersFinder {
    public static void main(String[] args) {
        try (Scanner stdin = new Scanner(System.in)) {
            int[] numbers = new int[3];

            for (int i = 0; i < numbers.length; i++) {
                System.out.printf("%d 番目の数字を入力してください: ", i + 1);
                numbers[i] = stdin.nextInt();
            }

            if (isLargest1stNum(numbers)) {
                System.out.println("numbers[0]=" + numbers[0]);
                System.out.printf("1番目に入力した数字が一番大きい");
            } else if (isLargest2ndNum(numbers)) {
                System.out.printf("2番目に入力した数字が一番大きい");
            } else {
                System.out.printf("3番目に入力した数字が一番大きい");
            }
        }
    }

    private static boolean isLargest1stNum(int[] numbers) {
        return numbers[0] >= numbers[1] && numbers[0] >= numbers[2];
    }

    private static boolean isLargest2ndNum(int[] numbers) {
        return numbers[1] >= numbers[0] && numbers[1] >= numbers[2];
    }

}
