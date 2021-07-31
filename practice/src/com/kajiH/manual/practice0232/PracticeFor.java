package com.kajiH.manual.practice0232;

/**
 * PracticeFor
 */
public class PracticeFor {

    private final static int TIMES = 12;

    public static void main(String[] args) {
        // textSpecificTimesPrinter();
        // ReverseOrderNumberPrinter();
        ArrayElementsPrinter();
    }

    private static void textSpecificTimesPrinter() {

        for (int i = 1; i <= TIMES; i++) {
            System.out.printf("%d: Java は簡単で楽しい。\n", i);
        }
    }

    private static void ReverseOrderNumberPrinter() {
        for (int i = TIMES; i > 0; i--) {
            System.out.println(i);
        }
    }

    private static void ArrayElementsPrinter() {
        String[] dogTypes = { "Chiwawa", "Pomeranian", "Bulldog", "Akita",
                "Poodle" };

        for (int i = 0; i < dogTypes.length; i++) {
            System.out.printf("dogTypes の %d 番目の犬種は %s です。\n", i, dogTypes[i]);
        }

    }
}