package com.kajiH.manual.practice0233;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PracticeExpansionFor {
    public static void main(String[] args) {
        // ArrayElementsAdder();
        ListElementPrinter();
    }

    private static void ArrayElementsAdder() {
        int[] numbers = { 3, 4, 5, -5, 0, 12 };
        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        System.out.printf("配列 numbers の %d 個の要素の合計 => %d\n", numbers.length,
                sum);
    }

    private static void ListElementPrinter() {
        List<String> list = new ArrayList<>();

        list.add("000");
        list.add("111");
        list.add("222");

        for (String str : list) {
            System.out.printf("%d 番目の要素 => %s\n", list.indexOf(str), str);
        }
    }
}
