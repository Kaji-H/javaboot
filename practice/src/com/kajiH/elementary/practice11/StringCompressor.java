package com.kajiH.elementary.practice11;

public class StringCompressor {
    public static void main(String[] args) {
        String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
        System.out.println(text);

        System.out.println();

        text = decode("A5B10CD9E2F5G");
        System.out.println(text);
    }

    private static String encode(String string) {
        String text = "";
        int count = 0;

        for (int i = 0; i < string.length(); i++) {
            count++;

            if (!isSameCharactersAsBehind(string, i)) {
                text += getEncodeCharacter(string.charAt(i), count);
                count = 0;
            }
        }
        return text;
    }

    private static String getEncodeCharacter(char character, int count) {
        StringBuilder build = new StringBuilder();
        build.append(character);

        if (!isOneWord(count)) {
            build.append(count);
        }
        return build.toString();
    }

    private static boolean isOneWord(int count) {
        return count == 1;
    }

    private static boolean isSameCharactersAsBehind(String string, int wordElements) {
        int nextCharElements = wordElements + 1;

        if (isSame(string.length(), nextCharElements)) {
            return false;
        }

        return string.charAt(wordElements) == string.charAt(nextCharElements);
    }

    private static boolean isSame(int length, int num) {
        return length == num;
    }

    private static String decode(String string) {
        String text = "";

        for (int i = 0; i < string.length(); i++) {
            if (!isNumber(string.charAt(i))) {
                text += string.charAt(i);
                continue;
            }
            String numStr = getNumStr(string, i);
            int count = convertStringToInteger(numStr);
            int charElements = text.length() - 1;

            text += getDecodeCharacter(text.charAt(charElements), count);
        }

        return text;
    }

    private static String getNumStr(String string, int i) {
        return null;
    }

    private static boolean isNumber(char character) {
        StringBuilder build = new StringBuilder();
        build.append(character);

        try {
            Integer.parseInt(build.toString());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int convertStringToInteger(String numStr) {
        StringBuilder build = new StringBuilder();
        build.append(numStr);

        return Integer.parseInt(build.toString());
    }

    private static String getDecodeCharacter(char character, int count) {
        StringBuilder build = new StringBuilder();
        build.append(character);

        String text = "";

        for (int i = 0; i < count; i++) {
            text += build.toString();
        }

        return text;
    }

}
