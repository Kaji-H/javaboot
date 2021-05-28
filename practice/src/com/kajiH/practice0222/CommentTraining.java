package com.kajiH.practice0222;

import java.util.Scanner;

/**
 * コメントを付与する練習クラス
 * 
 * @author kaji hiroaki
 */
public class CommentTraining {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int intInput = 0;
        String strInput = "";
        boolean isNotCorrectInput = true;

        System.out.print("数字を入力してください:");

        // 不正な入力がある限りループ
        while (isNotCorrectInput) {
            strInput = stdin.nextLine();
            System.out.println();

            try {
                intInput = Integer.parseInt(strInput);
            } catch (NumberFormatException e) {
                System.out.println("入力が数字ではありませんでした.");
                System.out.print("数字を入力してください:");
                continue;
            }
            isNotCorrectInput = false;
        }
        boolean isOddInput = isOddInput(intInput);

        // 入力値の判定結果
        if (isOddInput)
            System.out.printf("%d は奇数です.", intInput);
        if (!isOddInput)
            System.out.printf("%d は奇数ではありません.", intInput);

        stdin.close();
    }

    /**
     * 奇数であるかを判定する
     * 
     * @param input
     * @return input が奇数であれば true / それ以外は false
     */
    private static boolean isOddInput(int input) {
        return input % 2 != 0;
    }
}
