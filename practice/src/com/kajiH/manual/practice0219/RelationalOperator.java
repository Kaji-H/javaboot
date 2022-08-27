package com.kajiH.manual.practice0219;

public class RelationalOperator {
    public static void main(String[] args) {
        // 変数宣言 declare variables
        int a = 2;
        int b = 3;
        int c = 5;
        // 変数の値を表示 value of a, b and c
        System.out.printf("a = %d, b = %d, c = %d %n%n", a, b, c);
        // a と b + c は同じでない
        System.out.println(a != b + c);
        // a は c より大きい
        System.out.println(a > c);
        // a + b と c は同じ
        System.out.println(a + b == c);
        // b は a 以上
        System.out.println(a <= b);
        // a は b より小さい
        System.out.println(a < b);

        // a + b は c 以上
        System.out.println(a + b >= c);
    }
}
