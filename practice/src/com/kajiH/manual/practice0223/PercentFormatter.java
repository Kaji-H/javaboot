package com.kajiH.manual.practice0223;

import java.text.DecimalFormat;

public class PercentFormatter {
    public static void main(String[] args) {
        double value = 123456.78935465;

        // System.out.printf("%,.2f\n", value * 100);

        DecimalFormat percentFormat = new DecimalFormat("0,000.##%");

        System.out.println(percentFormat.format(value));
    }
}
