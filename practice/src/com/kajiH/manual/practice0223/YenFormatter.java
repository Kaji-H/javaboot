package com.kajiH.manual.practice0223;

import java.text.NumberFormat;

/**
 * YenFormatter
 */
public class YenFormatter {

    public static void main(String[] args) {
        int money = 123456789;
        // DecimalFormat moneyFormat = new DecimalFormat("\u00A4");
        //
        // System.out.println(moneyFormat.format(money));

        NumberFormat yenFormat = NumberFormat.getCurrencyInstance();

        System.out.println(yenFormat.format(money));

    }
}