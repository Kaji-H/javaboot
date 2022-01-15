package com.kajih.practice10_3;

import java.util.ArrayList;
import java.util.List;

public class Queue implements IQueue, Prioritable {

    private int NOT_PRIORITY = 0;
    private int FIRST_ELEMENS = 0;

    private List<String> list = new ArrayList<>();
    private List<Integer> priorityList = new ArrayList<>();

    @Override
    public void push(String data) {
        list.add(data);
        priorityList.add(NOT_PRIORITY);
    }

    @Override
    public void push(String data, int priority) {
        list.add(data);
        priorityList.add(priority);
    }

    @Override
    public String pop() {
        int elements = FIRST_ELEMENS;

        if (hasPriority()) {
            elements = setHighPriorityElements();
        }

        String data = list.get(elements);
        list.remove(elements);
        priorityList.remove(elements);

        return data;
    }

    private int setHighPriorityElements() {
        int tempElements = 0;

        for (int i = 0; i < priorityList.size(); i++) {
            if (isHighPriority(tempElements, i)) {
                tempElements = i;
            }
        }
        return tempElements;
    }

    private boolean isHighPriority(int tempElements, int i) {
        return priorityList.get(tempElements) < priorityList.get(i);
    }

    private boolean hasPriority() {
        for (int degree : priorityList) {
            if (degree != NOT_PRIORITY) {
                return true;
            }
        }
        return false;
    }

}
