package com.kajih.practice10;

import java.util.ArrayList;
import java.util.List;

public class Queue {

    private static final String MESSAGE_EMPTY = "空です。¥n";
    int FIRST_ELEMENTS = 0;
    List<String> list = new ArrayList<>();
    List<Integer> plist = new ArrayList<>();

    public void push(String data) {
        list.add(data);
    }

    public void push(String data, int priority) {
        list.add(data);
        plist.add(priority);
    }

    public String pop() {
        if (isNullList()) {
            return MESSAGE_EMPTY;
        }

        int elements = FIRST_ELEMENTS;

        if (!isNullList()) {
            elements = receiveHighPriority(plist);
            plist.remove(elements);
        }

        String data = list.get(elements);
        list.remove(elements);

        return data;
    }

    private int receiveHighPriority(List<Integer> list) {
        int elements = 0;
        int maxPriority = 0;

        for (int i = 0; i < list.size(); i++) {
            if (maxPriority < list.get(i)) {
                elements = i;
                maxPriority = list.get(i);
            }
        }

        return elements;
    }

    private boolean isNullList() {
        return list.size() == 0;
    }

}
