package com.kajiH.manual.practice0223;

/**
 * WeightPrintMessageBuilder
 */
public class WeightPrintMessageBuilder {

    public static void main(String[] args) {
        int value = 7777;
        String unit = "キロ";
        String message = String.format("僕の体重は %d %s です。\n", value, unit);

        System.out.println(message);

    }
}