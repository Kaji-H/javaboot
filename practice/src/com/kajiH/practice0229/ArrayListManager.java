package com.kajiH.practice0229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListManager {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        boolean isListEmpty = list.isEmpty();
        System.out.println("listの要素が空かどうか　=> " + isListEmpty);

        list.add("000");
        list.add("111");
        list.add("222");

        int isSize = list.size();
        System.out.println("listの要素数　=> " + isSize);

        String keyword = "111";
        boolean hasKeyword = list.contains(keyword);
        System.out.println("listの中に111は　=> " + hasKeyword);

        int targetIndex = 2;
        String target = list.get(targetIndex);
        System.out.println("listの" + targetIndex + "番目は　=> " + target);

        target = "000";
        targetIndex = list.indexOf(target);
        System.out.println("listの000の要素は　=> " + targetIndex);

        list.set(2, "UPDATE");
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("listの" + i + "番目の要素　=> " + list.get(i));
        }

    }
}
