package com.kajiH.elementary.practice15;

import java.util.ArrayList;
import java.util.List;

public class StringSplitter2 {

    private static final String LINE_BREAK_CODE = "¥n";

    private static final String[] PUNCTUATION_ARRAY = { "、", "," };
    private static final String[] PERIOD_ARRAY = { "。", "." };
    private static final String[] LINE_BREAK_CODE_ARRAY = { "¥n", "\n" };

    public static void main(String[] args) {
        // List<String> lines =
        // splitWithLineBreakCode("１行目。¥n２行目。¥n３行目。¥n４行目。¥n¥n５行目¥n");

        // List<String> lines =
        // splitWithLineBreakCodeAndPeriod("１行目。２行目。¥n３行目。４行目。¥n¥n５行目。¥n" + "a");

        // List<String> lines =
        // splitFixedLengthWithLineBreakCodeAndPeriod("このプログラムは、文字列を指定された幅で改行するサンプルプログラムです。",
        // 6);

        List<String> lines = splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod(
                "このプログラムは、句読点を行頭禁則処理するサンプル。¥n" + "最後の行です", 8);

        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static List<String> splitWithLineBreakCode(String line) {
        List<String> lines = new ArrayList<>();
        lines.add(line);

        for (String lineBreakCode : LINE_BREAK_CODE_ARRAY) {
            List<String> tempLines = lines;
            lines = new ArrayList<>();

            for (String str : tempLines) {
                lines.addAll(splitWith(lineBreakCode, str));
            }

        }
        return lines;
    }

    private static List<String> splitWith(String wordUsedForDivision, String line) {
        List<String> lines = new ArrayList<>();
        String[] strArray = line.split(wordUsedForDivision);

        for (String str : strArray) {
            lines.add(str);
        }
        return lines;
    }

    private static List<String> splitWithLineBreakCodeAndPeriod(String line) {
        List<String> lines = new ArrayList<>();
        List<String> splitedLinesWithLineBreakCode = splitWithLineBreakCode(line);

        for (String str : splitedLinesWithLineBreakCode) {
            str = addLineBreakCodeBehindPeriod(str);
            lines.addAll(splitWithLineBreakCode(str));
        }

        return lines;
    }

    private static String addLineBreakCodeBehindPeriod(String line) {
        String str = line;

        for (String period : PERIOD_ARRAY) {
            str = str.replace(period, period + LINE_BREAK_CODE);
        }

        return str;
    }

    private static List<String> splitFixedLengthWithLineBreakCodeAndPeriod(String line, int fixedLength) {
        List<String> lines = new ArrayList<>();
        List<String> splitedLinesWithLineBreakCodeAndPeriod = splitWithLineBreakCodeAndPeriod(line);

        for (String str : splitedLinesWithLineBreakCodeAndPeriod) {
            lines.addAll(splitFixedLength(str, fixedLength));
        }

        return lines;
    }

    private static List<String> splitFixedLength(String str, int fixedLength) {
        List<String> lines = new ArrayList<>();

        int beginIndex = 0;
        int endIndex = fixedLength;

        while (isOverIndex(str.length(), endIndex)) {
            lines.add(str.substring(beginIndex, endIndex));

            beginIndex = endIndex;
            endIndex += fixedLength;
        }

        if (!isEquals(str.length(), beginIndex)) {
            lines.add(str.substring(beginIndex));
        }

        return lines;
    }

    private static List<String> splitFixedLengthJaHyphenationWithLineBreakCodeAndPeriod(String line, int fixedLength) {
        List<String> lines = new ArrayList<>();
        List<String> splitedLinesWithLineBreakCodeAndPeriod = splitWithLineBreakCodeAndPeriod(line);

        for (String str : splitedLinesWithLineBreakCodeAndPeriod) {
            lines.addAll(splitFixedLengthJaHyphenation(str, fixedLength));
        }

        return lines;
    }

    private static List<String> splitFixedLengthJaHyphenation(String str, int fixedLength) {
        List<String> lines = new ArrayList<>();
        int beginIndex = 0;
        int endIndex = fixedLength;

        while (isOverIndex(str.length(), endIndex)) {
            if (isHyphenation(str, endIndex)) {
                endIndex++;
            }

            lines.add(str.substring(beginIndex, endIndex));

            beginIndex = endIndex;
            endIndex += fixedLength;
        }

        if (!isEquals(str.length(), beginIndex)) {
            lines.add(str.substring(beginIndex));
        }

        return lines;
    }

    private static boolean isHyphenation(String line, int index) {
        int nextIndex = index + 1;

        if (!isOverIndex(line.length(), nextIndex)) {
            return false;
        }

        String str = line.substring(index, nextIndex);
        for (String period : PERIOD_ARRAY) {
            if (str.equals(period)) {
                return true;
            }
        }

        for (String punctuation : PUNCTUATION_ARRAY) {
            if (str.equals(punctuation)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isOverIndex(int length, int endIndex) {
        return length >= endIndex;
    }

    private static boolean isEquals(int a, int b) {
        return a == b;
    }

}
