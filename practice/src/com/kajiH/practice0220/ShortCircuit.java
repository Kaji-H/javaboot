package com.kajiH.practice0220;

public class ShortCircuit {
    public static void main(String[] args) {
        String str = null;
        // 必ず getTrue() メソッドが実行されないように
        // ショートサーキットとなるように ? を論理演算子で置き換えなさい
        if (str != null & getTrue()) {
            System.out.println("1 つ目の if 文の中に入りました.");
        }
        // getFalse() メソッドが実行されないように
        // ショートサーキットとなるように ? を論理演算子で置き換えなさい
        if (str == null | getFalse()) {
            System.out.println("2 つ目の if 文の中に入りました.");
        }
    }

    public static boolean getTrue() {
        System.out.println("getTrue() を実行しました.");
        return true;
    }

    public static boolean getFalse() {
        System.out.println("getFalse() を実行しました.");
        return false;
    }
}
