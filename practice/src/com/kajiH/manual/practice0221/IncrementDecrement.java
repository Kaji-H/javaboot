package com.kajiH.manual.practice0221;

public class IncrementDecrement {
    public static void main(String[] args) {
        int value = 5;
        // -1 した後に value の値を表示する
        System.out.println(--value);
        // value の値を表示した後に + 1 する
        System.out.println(value++);
        // +1 した後に value の値を表示する
        System.out.println(++value);
        // value の値を表示した後に - 1 する
        System.out.println(value--);
        System.out.println();
        System.out.println(value);
    }
}
