package com.kajih.practice12.practice12_1;

public class MathAdder {
    public static void main(String[] args) {
        // MathUtils utils = new MathUtils();

        long resultAddLong = MathUtils.addLong(100L, 20L);
        int resultAddIns = MathUtils.addInts(9, 1, 22, 72, 5, 6);

        System.out.printf("addLong メソッドの結果: %d\n", resultAddLong);
        System.out.printf("addInts メソッドの結果: %d\n", resultAddIns);
    }
}
