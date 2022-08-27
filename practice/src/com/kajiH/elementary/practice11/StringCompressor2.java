package com.kajiH.elementary.practice11;

import java.util.ArrayList;
import java.util.List;

public class StringCompressor2 {
    private static final int FIRST_COUNT = 1;
    private static final String EMPTY_STR = "";

    public static void main(String[] args) {
        String text = "AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG";

        text = encode(text);
        System.out.println(text);

        System.out.println();

        text = decode(text);
        System.out.println(text);
    }

    private static String encode(String text) {
        char[] textArray = text.toCharArray();
        List<Character> characterList = new ArrayList<>();

        int count = FIRST_COUNT;

        for (char character : textArray) {
            if (isSameAsPreviousCharList(characterList, character)) {
                count++;
                continue;
            }

            if (!isFirstCount(count)) {
                addCountToList(characterList, count);
                count = FIRST_COUNT;
            }

            characterList.add(character);
        }

        String encodeText = convertCharListToString(characterList);

        return encodeText;
    }

    private static boolean isFirstCount(int count) {
        return count == FIRST_COUNT;
    }

    private static void addCountToList(List<Character> characterList, int count) {
        String countStr = Integer.toString(count);
        char[] countCharList = countStr.toCharArray();

        for (char character : countCharList) {
            characterList.add(character);
        }

    }

    private static String convertCharListToString(List<Character> characterList) {
        StringBuilder build = new StringBuilder();

        for (char c : characterList) {
            build.append(c);
        }

        return build.toString();
    }

    private static boolean isSameAsPreviousCharList(List<Character> characterList, char character) {

        if (characterList.size() == 0) {
            return false;
        }

        return characterList.get(characterList.size() - 1) == character;
    }

    private static String decode(String text) {
        char[] textArray = text.toCharArray();
        List<Character> characterList = new ArrayList<>();

        String tempNumStr = EMPTY_STR;

        for (char character : textArray) {
            if (isNumber(character)) {
                tempNumStr += convertCharToString(character);
                continue;
            }

            if (!isEmpty(tempNumStr)) {
                addMoreLettersInBack(characterList, tempNumStr);
                tempNumStr = EMPTY_STR;
            }

            characterList.add(character);
        }

        String decodeText = convertCharListToString(characterList);

        return decodeText;
    }

    private static void addMoreLettersInBack(List<Character> characterList, String tempNumStr) {
        int tempNum = Integer.parseInt(tempNumStr);

        int maxListElements = characterList.size() - 1;
        char tempChar = characterList.get(maxListElements);

        for (int i = 1; i < tempNum; i++) {
            characterList.add(tempChar);
        }
    }

    private static boolean isEmpty(String tempNumStr) {
        return tempNumStr.equals(EMPTY_STR);
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

    private static String convertCharToString(char character) {
        StringBuilder build = new StringBuilder();
        build.append(character);

        return build.toString();
    }

}
