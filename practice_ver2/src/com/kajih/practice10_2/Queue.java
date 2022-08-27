package com.kajih.practice10_2;

import java.util.ArrayList;
import java.util.List;

public class Queue implements IQueue {

    private final int FIRST = 0;
    private final int NO_PRIORITY = 0;

    private List<String> list = new ArrayList<>();
    private List<Integer> priorityList = new ArrayList<>();

    @Override
    public void push(String data) {
        this.list.add(data);
        this.priorityList.add(NO_PRIORITY);
    }

    @Override
    public void push(String data, int priority) {
        this.list.add(data);
        this.priorityList.add(priority);
    }

    @Override
    public String pop() {
        int elements = FIRST;

        if (hasPriority()) {
            elements = generateElements();
        }

        String temp = this.list.get(elements);

        this.list.remove(elements);
        this.priorityList.remove(elements);

        return temp;
    }

    private int generateElements() {
        int elements = FIRST;
        int tempPriority = NO_PRIORITY;

        for (int i = 0; i < priorityList.size(); i++) {
            if (isOver(tempPriority, priorityList.get(i))) {
                tempPriority = priorityList.get(i);
                elements = i;
            }
        }
        return elements;
    }

    private boolean hasPriority() {
        for (int i = 0; i < priorityList.size(); i++) {
            if (isOver(NO_PRIORITY, priorityList.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isOver(int a, int b) {
        return a < b;
    }

}
