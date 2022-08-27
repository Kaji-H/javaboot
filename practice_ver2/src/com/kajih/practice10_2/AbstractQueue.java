package com.kajih.practice10_2;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractQueue {

    protected final int NO_PRIORITY = 0;

    protected List<String> list = new ArrayList<>();
    protected List<Integer> priorityList = new ArrayList<>();

    public void push(String data) {
        this.list.add(data);
        this.priorityList.add(NO_PRIORITY);
    }

    public void push(String data, int priority) {
        this.list.add(data);
        this.priorityList.add(priority);
    }

    public abstract String pop();
}
