package com.kajih.practice10_3;

import java.util.ArrayList;
import java.util.List;

public class Stack implements IQueue {

    private List<String> list = new ArrayList<>();

    @Override
    public void push(String data) {
        list.add(data);
    }

    @Override
    public String pop() {
        int lastElements = list.size() - 1;
        String data = list.get(lastElements);

        list.remove(lastElements);

        return data;
    }

}
