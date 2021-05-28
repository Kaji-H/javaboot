package com.kajiH.practice0226;

public class VariableNamesCorrecter {
    public static void main(String[] args) {
        String ballpointPenCode = "BPBK-007";
        int ballpointPenPrice = 110;
        int ballpointPenNum = 1;
        int ballpointPenSumPrice = 0;

        String noteCode = "NTBK-102 20P";
        int notePrice = 80;
        int noteNum = 5;
        int noteSumPrice = 0;

        final double salesTax = 1.10;

        int purchasePrice = 0;

        ballpointPenSumPrice = (int) Math.round(
                (ballpointPenPrice * ballpointPenNum) * salesTax);
        noteSumPrice = (int) Math.round((notePrice * noteNum) * salesTax);
        purchasePrice = ballpointPenSumPrice + noteSumPrice;
        System.out.printf("%12s: 1 個 %3d 円 × %1d 個 = %3d 円（税込）%n",
                ballpointPenCode, ballpointPenPrice, ballpointPenNum,
                ballpointPenSumPrice);
        System.out.printf("%12s: 1 個 %3d 円 × %1d 個 = %3d 円（税込）%n", noteCode,
                notePrice, noteNum, noteSumPrice);
        System.out.printf("すべての文房具の合計金額 = %d 円（税込）%n", purchasePrice);
    }
}
