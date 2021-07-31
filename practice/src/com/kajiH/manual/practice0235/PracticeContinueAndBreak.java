package com.kajiH.manual.practice0235;

public class PracticeContinueAndBreak {
    public static void main(String[] args) {
        // EvenNumbersAdder();
        // LaveledContinueStatement();
        // BrakeNest();
        LabeledBrakeNest();
    }

    private static void EvenNumbersAdder() {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.printf("i = %d\n", i);
                sum += i;
            }
        }

        System.out.printf("sum = %d\n", sum);

    }

    private static void LaveledContinueStatement() {
        final int HIDE_LINE_NUM = 7;
        final int HIDE_COLUMN_NUM = 3;
        final String LABEL = "@@@@@@@@@";

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {

                if (i == HIDE_LINE_NUM || j == HIDE_COLUMN_NUM) {
                    System.out.printf("%s  ", LABEL);
                    continue;
                }

                System.out.printf("%d X %d = %d  ", i, j, i * j);

            }
            System.out.println();
        }

    }

    private static void BrakeNest() {
        final int UNTIL_NUMBER_PRINT = 20;
        int result;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                result = i * j;

                if (result > UNTIL_NUMBER_PRINT) {
                    break;
                }

                System.out.printf("%2dX%2d=%2d ", i, j, result);
            }
            System.out.println();
        }
    }

    private static void LabeledBrakeNest() {
        final int UNTIL_NUMBER_PRINT = 20;
        int result;

        Label:
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                result = i * j;

                if (result > UNTIL_NUMBER_PRINT) {
                    break Label;
                }

                System.out.printf("%2dX%2d=%2d ", i, j, result);
            }
            System.out.println();
        }
    }
}
