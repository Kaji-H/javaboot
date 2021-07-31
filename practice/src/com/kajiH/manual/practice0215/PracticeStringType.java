package com.kajiH.manual.practice0215;

/**
 * PracticeStringType
 */
public class PracticeStringType {

    private static final String HALF_WIDTH_SPACE = " ";

    private static final int STARTING_POINT = 2;
    private static final int LAST_POINT = 6;

    public static void main(String[] args) {
        stringSplitter();
        stringConcatter();
        multipleStringsConcatter();
        stringCutOut();
    }

    private static void stringSplitter() {
        String name = "山本 一郎";
        String[] nameList = name.split(" ");

        // for (String n : nameList) {
        // System.out.println(n);
        // }

        System.out.printf("姓：%s  名：%s\n", nameList[0], nameList[1]);
    }

    private static void stringConcatter() {
        String familyName = "山本";
        String firstName = "一郎";
        String name = familyName.concat(firstName);
        // name = firstName.concat(familyName);

        System.out.printf("僕のフルネームは%sです。\n", name);
    }

    private static void multipleStringsConcatter() {
        StringBuilder sb = new StringBuilder();
        String familyName = "山本";
        String firstName = "一郎";

        sb.append(familyName);
        sb.append(HALF_WIDTH_SPACE);
        sb.append(firstName);

        System.out.println(sb.toString());
    }

    private static void stringCutOut() {
        String targetName = "investment";

        System.out.println(targetName.substring(STARTING_POINT, LAST_POINT));
    }
}