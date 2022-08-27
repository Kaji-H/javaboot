package com.kajiH.elementary.practice8;

/**
 * CommaSeparated
 */
public class CommaSeparated {

    private static final int MINUS_ONE = -1;
    private static final String WORD_THAT_MINUS = "-";
    private static final String WORD_THAT_COMMA = ",";

    public static void main(String[] args) {
        System.out.println(commaSeparatedString(123));
        System.out.println(commaSeparatedString(12345));
        System.out.println(commaSeparatedString(1234567));
        System.out.println(commaSeparatedString(-1234567));
        System.out.println(commaSeparatedString(123456789));
        System.out.println(commaSeparatedString(-123456789));
    }

    private static String commaSeparatedString(int num) {
        String numWithComma = "";
        int absoluteValue = num;

        if (isMinus(num)) {
            numWithComma += WORD_THAT_MINUS;
            absoluteValue *= MINUS_ONE;
        }

        String strNum = Integer.toString(absoluteValue);
        int digits = strNum.length();

        for (int i = 0; i < digits; i++) {

            if (isAddComma(digits, i)) {
                numWithComma += WORD_THAT_COMMA;
            }

            numWithComma += strNum.charAt(i);
        }

        return numWithComma;
    }

    private static boolean isAddComma(int digits, int currentNum) {
        int currentDigits = digits - currentNum;

        if (isSame(digits, currentDigits)) {
            return false;
        }

        return currentDigits % 3 == 0;
    }

    private static boolean isSame(int digits, int currentDigits) {
        return currentDigits == digits;
    }

    private static boolean isMinus(int num) {
        return num < 0;
    }
}