package com.kajiH.elementary.practice11;

public class StringCompressor {
    public static void main(String[] args) {
        String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
        System.out.println(text);

        System.out.println();

        // text = decode("A5B10CD9E2F5G");
        System.out.println(text);
    }

    private static String encode(String string) {
        String text = "";
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            count++;

            if (!isSameCharactersAsBehind(string, i)) {
                text += getDecodeCharacter(string.charAt(i), count);
                count = 0;
            }

        }

        return text;
    }

    private static String getDecodeCharacter(char charAt, int count) {
        StringBuilder build = new StringBuilder();
        // build.append("" + charAt + count);
        return build.toString();
    }

    private static boolean isSameCharactersAsBehind(String string, int num) {
        if (isSame(string.length(), num)) {
            return false;
        }

        return string.charAt(num) == string.charAt(num + 1);
    }

    private static boolean isSame(int length, int num) {
        return length == num;
    }

    private static String decode(String string) {
        String text = "";

        for (int i = 0; i < string.length(); i++) {
            if (isNumber(string, i)) {
                int count = convertStringToInteger(string.charAt(i));
                text += getEncodeCharacter(text, count);
            }

            text += string.charAt(i);
        }

        return text;
    }

    private static String getEncodeCharacter(String text, int count) {
        return null;
    }

    private static int convertStringToInteger(char charAt) {
        return 0;
    }

    private static boolean isNumber(String string, int i) {
        return false;
    }

}
