package com.kajiH.elementary.practice11;

public class StringCompressor3 {

    private static final int FIRST_ELEMENTS = 0;
    private static final int INIT_COUNT = 0;
    private static final char TEMP_CHAR = '-';
    private static final String EMPTY_STRING = "";

    public static void main(String[] args) {
        String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
        System.out.println(text);

        text = decode("A5B10CD9E2F5G");
        System.out.println(text);
    }

    private static String encode(String string) {
        String encodeStr = EMPTY_STRING;
        char tempChar = string.charAt(FIRST_ELEMENTS);
        int countChar = INIT_COUNT;
        int countElements = INIT_COUNT;

        while (!isNotOverStrLength(string.length(), countElements)) {
            countChar++;
            countElements++;

            if (isNotEqualsNextChar(tempChar, countElements, string)) {
                encodeStr += generateEncodeWord(tempChar, countChar);

                tempChar = receiveCharInStr(string, countElements);
                countChar = INIT_COUNT;
            }
        }

        return encodeStr;
    }

    private static String decode(String string) {
        String decodeStr = EMPTY_STRING;
        char tempChar = string.charAt(FIRST_ELEMENTS);
        int countChar = INIT_COUNT;
        int countElements = INIT_COUNT;

        while (!isNotOverStrLength(string.length(), countElements)) {

            countElements++;

            if (isNumAndInStrLength(string, countElements)) {
                countChar = generateCountChar(countChar, string.charAt(countElements));
                continue;
            }

            decodeStr += generateDecodeWord(tempChar, countChar);

            tempChar = receiveCharInStr(string, countElements);
            countChar = INIT_COUNT;

        }

        return decodeStr;
    }

    private static int generateCountChar(int countChar, char countElements) {
        if (!isInitCount(countChar)) {
            countChar = raiseDigit(countChar);
        }
        countChar += changeNum(countElements);
        return countChar;
    }

    private static String generateEncodeWord(char addChar, int count) {
        String str = EMPTY_STRING;

        str += addChar;

        if (!isOneChar(count)) {
            str += count;
        }

        return str;
    }

    private static char receiveCharInStr(String string, int num) {
        if (isEqualsStrLength(string, num)) {
            return TEMP_CHAR;
        }
        return string.charAt(num);
    }

    private static int changeNum(char charAt) {
        return Character.getNumericValue(charAt);
    }

    private static int raiseDigit(int countChar) {
        return countChar * 10;
    }

    private static String generateDecodeWord(char tempChar, int countChar) {
        String str = EMPTY_STRING;

        for (int i = 0; i <= countChar; i++) {
            str += tempChar;
        }

        return str;
    }

    private static boolean isInitCount(int countChar) {
        return countChar == INIT_COUNT;
    }

    private static boolean isOneChar(int count) {
        return count == 1;
    }

    private static boolean isEqualsStrLength(String string, int num) {
        return string.length() == num;
    }

    private static boolean isNotEqualsNextChar(char tempChar, int numOfChar, String strng) {
        return numOfChar == strng.length() || tempChar != strng.charAt(numOfChar);
    }

    private static boolean isNotOverStrLength(int length, int numOfChar) {
        return numOfChar < length;
    }

    private static boolean isNumAndInStrLength(String string, int countElements) {
        return string.length() > countElements && Character.isDigit(string.charAt(countElements));
    }
}