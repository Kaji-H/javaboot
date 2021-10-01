package com.kajiH.elementary.practice15;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringsSplitter {

    private static final String PUNCTUATION = "、";
    private static final String PERIOD = "。";
    private static final String NEW_LINE = "¥n";

    public static void main(String[] args) {
        // List<String> lines =
        // splitWithLineBreakCode("１行目。¥n２行目。¥n３行目。¥n４行目。¥n¥n５行目¥n");

        // List<String> lines =
        // splitWithLineBreakCodeAndPeriod("１行目。２行目。¥n３行目。４行目。¥n¥n５行目。");

        // List<String> lines =
        // splitFixedLengthWithLineBreakCodeAndPeriod("このプログラムは、文字列を指定された幅で改行するサンプルプログラムです。",
        // 6);

        List<String> lines = splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod(
                "このプログラムは、句読点を行頭禁則処理するサンプル。¥n" + "最後の行です", 8);

        for (String line : lines) {
            System.out.println(line);
        }
    }

    private static List<String> splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod(String string,
            int lineBreakPosition) {
        List<String> tempLists = splitWithLineBreakCode(string);
        List<String> lists = new ArrayList<>();

        String stringWithNewLine = "";

        for (String str : tempLists) {
            stringWithNewLine += addNewLineToFixedLengthJaHyphenation(str, lineBreakPosition);
        }

        lists = splitWithLineBreakCode(stringWithNewLine);

        return lists;
    }

    private static String addNewLineToFixedLengthJaHyphenation(String string, int lineBreakPosition) {
        StringBuilder build = new StringBuilder();
        build.append(string);

        int count = 0;
        int countElements = 0;

        while (isInRange(build.length(), countElements)) {

            if (isSame(lineBreakPosition, count)) {
                if (build.charAt(countElements) == PUNCTUATION.charAt(0)
                        || build.charAt(countElements) == PERIOD.charAt(0)) {

                    countElements++;

                    if (isSame(build.length(), countElements)) {
                        break;
                    }
                }
                build.insert(countElements, NEW_LINE);

                countElements += NEW_LINE.length();
                count = 0;
            }
            count++;
            countElements++;
        }
        String strWithNewLine = build.toString() + NEW_LINE;

        return strWithNewLine;
    }

    private static List<String> splitFixedLengthWithLineBreakCodeAndPeriod(String string, int lineBreakPosition) {
        List<String> tempLists = splitWithLineBreakCode(string);
        List<String> lists = new ArrayList<>();
        String stringWithNewLine = "";

        for (String str : tempLists) {
            stringWithNewLine += addNewLineToFixedLength(str, lineBreakPosition);
        }

        lists = splitWithLineBreakCode(stringWithNewLine);

        return lists;
    }

    private static String addNewLineToFixedLength(String string, int lineBreakPosition) {
        StringBuilder build = new StringBuilder();
        build.append(string);

        int count = 0;
        int countElements = 0;

        while (isInRange(build.length(), countElements)) {

            if (isSame(lineBreakPosition, count)) {
                build.insert(countElements, NEW_LINE);

                countElements += NEW_LINE.length();
                count = 0;
            }
            count++;
            countElements++;
        }
        String strWithNewLine = build.toString() + NEW_LINE;

        return strWithNewLine;
    }

    private static boolean isSame(int lineBreakPosition, int count) {
        return count == lineBreakPosition;
    }

    private static boolean isInRange(int strNum, int countElements) {
        return strNum > countElements;
    }

    private static List<String> splitWithLineBreakCodeAndPeriod(String string) {
        String remodelingStr = deleteOneAfterPeriod(string, NEW_LINE);
        remodelingStr = addOneAfterPeriod(remodelingStr, NEW_LINE);

        List<String> lines = splitWithLineBreakCode(remodelingStr);

        return lines;
    }

    private static String addOneAfterPeriod(String string, String newLine) {
        return string.replaceAll(PERIOD, PERIOD + newLine);
    }

    private static String deleteOneAfterPeriod(String string, String newLine) {
        return string.replaceAll(PERIOD + newLine, PERIOD);
    }

    private static List<String> splitWithLineBreakCode(String string) {
        List<String> lines = new ArrayList<>();
        Pattern p = Pattern.compile(NEW_LINE);

        for (String line : p.split(string)) {
            lines.add(line);
        }

        return lines;
    }
}
