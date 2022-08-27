package com.kajih.practice10;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    List<String> list = new ArrayList<>();

    public void push(String data) {
        list.add(data);
    }

    public String pop() {
        if (list.size() == 0) {
            return "空です。¥n";
        }
        int lastElements = list.size() - 1;
        String data = list.get(lastElements);
        list.remove(lastElements);
        return data;
    }
}
