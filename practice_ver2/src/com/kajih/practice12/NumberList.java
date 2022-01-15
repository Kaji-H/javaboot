package com.kajih.practice12;

import java.util.ArrayList;
import java.util.List;

public class NumberList {
    private static final int MIN_NUM = 3;
    private static final int MAX_NUM = 11;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        setNumFromMinToMaxIn(list);

        showAllLists(list);
    }

    private static void setNumFromMinToMaxIn(List<Integer> list) {
        for (int i = MIN_NUM; i <= MAX_NUM; i++) {
            list.add(i);
        }
    }

    private static void showAllLists(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("[%d] %d\n", i, list.get(i));
        }
    }
}
