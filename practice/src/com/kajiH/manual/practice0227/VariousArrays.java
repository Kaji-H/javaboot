package com.kajiH.manual.practice0227;

public class VariousArrays {

    private final static int INDEX_TO_WATCH = 2;

    public static void main(String[] args) {
        int[] intEmptyArray = new int[3];
        System.out.println(intEmptyArray[INDEX_TO_WATCH]);

        String[] strEmptyArray = new String[5];
        System.out.println(strEmptyArray[INDEX_TO_WATCH]);

        int[] idArray = { 100, 101, 102 };
        System.out.println(idArray[INDEX_TO_WATCH]);

        String[] namesArray = { "一堂雫", "山本一郎", "すきやばし次郎", "南島三郎", "伊藤四郎" };
        System.out.println(namesArray[INDEX_TO_WATCH]);

    }
}
