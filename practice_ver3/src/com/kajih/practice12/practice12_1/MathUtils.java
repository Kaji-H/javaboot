package com.kajih.practice12.practice12_1;

public class MathUtils {

    private MathUtils() {
        throw new IllegalStateException("ユーティリティクラスをインスタンス化しないでください。");
    }

    public static long addLong(long i, long j) {
        return i + j;
    }

    public static int addInts(int... ints) {
        int sum = 0;

        for (int i : ints) {
            sum += i;
        }

        return sum;
    }

}
