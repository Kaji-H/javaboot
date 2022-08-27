package com.kajih.practice10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomQueue {
    List<String> list = new ArrayList<>();
    Random RAND = new Random();

    public void push(String data) {
        list.add(data);
    }

    public String pop() {
        if (list.size() == 0) {
            return "空です。¥n";
        }
        int randElements = RAND.nextInt(list.size());
        String data = list.get(randElements);
        list.remove(randElements);
        return data;
    }
}