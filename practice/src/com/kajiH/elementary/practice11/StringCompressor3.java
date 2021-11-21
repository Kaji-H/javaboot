package com.kajiH.elementary.practice11;

public class StringCompressor3 {

    private static final int FIRST_INDEX = 0;
    private static final int INIT_COUNT = 0;
    private static final char HYPHEN_CHAR = '-';
    private static final String EMPTY = "";

    public static void main(String[] args) {
        String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
        System.out.println(text);

        text = decode("A5B10CD9E2F5G");
        System.out.println(text);
    }

    private static String encode(String string) {
        String encodeStr = EMPTY;
        char tempChar = string.charAt(FIRST_INDEX);
        int countSameChar = INIT_COUNT;
        int countElements = INIT_COUNT;

        while (!isOverStrLength(string.length(), countElements)) {
            countSameChar++;
            countElements++;

            if (!isEqualsNextChar(tempChar, countElements, string)) {
                encodeStr += generateEncodeWord(tempChar, countSameChar);

                tempChar = receiveNextCharInStr(string, countElements);
                countSameChar = INIT_COUNT;
            }
        }

        return encodeStr;
    }

    private static String decode(String string) {
        String decodeStr = EMPTY;
        char tempChar = string.charAt(FIRST_INDEX);
        int countChar = INIT_COUNT;
        int countElements = INIT_COUNT;

        while (!isOverStrLength(string.length(), countElements)) {

            countElements++;

            if (isNumOfCurrentChar(string, countElements)) {
                countChar = generateCountChar(countChar, string.charAt(countElements));
                continue;
            }

            decodeStr += generateDecodeWord(tempChar, countChar);

            tempChar = receiveNextCharInStr(string, countElements);
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
        String str = EMPTY;

        str += addChar;

        if (!isOneChar(count)) {
            str += count;
        }

        return str;
    }

    private static char receiveNextCharInStr(String string, int num) {
        if (isEqualsStrLength(string, num)) {
            return receiveCharWhenStringIndexOutOfBoundsException();
        }
        return string.charAt(num);
    }

    private static char receiveCharWhenStringIndexOutOfBoundsException() {
        return HYPHEN_CHAR;
    }

    private static int changeNum(char charAt) {
        return Character.getNumericValue(charAt);
    }

    private static int raiseDigit(int countChar) {
        return countChar * 10;
    }

    private static String generateDecodeWord(char tempChar, int countChar) {
        String str = EMPTY;

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

    private static boolean isEqualsNextChar(char tempChar, int nextIndex, String strng) {
        return nextIndex < strng.length() && tempChar == strng.charAt(nextIndex);
    }

    private static boolean isOverStrLength(int strLength, int numOfChar) {
        return numOfChar >= strLength;
    }

    private static boolean isNumOfCurrentChar(String string, int currentElements) {
        if (!isInStrLength(string, currentElements)) {
            return false;
        }

        if (!isNum(string.charAt(currentElements))) {
            return false;
        }

        return true;
    }

    private static boolean isInStrLength(String string, int currentElements) {
        return string.length() > currentElements;
    }

    private static boolean isNum(char character) {
        return Character.isDigit(character);
    }
}