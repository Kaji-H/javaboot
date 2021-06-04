package com.kajiH.practice0234;

import java.util.Scanner;

/**
 * PracticeWhile
 */
public class PracticeWhile {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        // UnitlTargetNumberLooper(stdin);
        UntilBlankLooper(stdin);

        stdin.close();
    }

    private static void UnitlTargetNumberLooper(Scanner stdin) {
        final int TARGET_NUMBER = 77;
        String inputNumber = "0";
        int count = 0;

        System.out.printf("%d が入力されたら終了します\n", TARGET_NUMBER);

        while (!inputNumber.equals(String.valueOf(TARGET_NUMBER))) {
            count++;
            System.out.printf("%d 回目：数字を入力してください：", count);
            inputNumber = stdin.next();

            try {
                Integer.parseInt(inputNumber);
            } catch (NumberFormatException e) {
                System.out.printf("  => 数字以外の値(%s)が入力されました\n", inputNumber);
            }
        }

        System.out.printf("%d が入力されたので終了します\n", TARGET_NUMBER);

    }

    private static void UntilBlankLooper(Scanner stdin) {
        final String BLANK = "";
        String inputtedString;
        int count = 0;

        System.out.println("文字が入力されず Enter キーが押されたら終了します. \n");
        /**
         * TODO: ここに処理を追加する
         */
        do {
            count++;
            System.out.printf("%d 回目：文字を入力してください：", count);
            inputtedString = stdin.nextLine();

        } while (!inputtedString.equals(BLANK));

        System.out.println("\n  => 文字が入力されなかったので終了しました.");

    }
}