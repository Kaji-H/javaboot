package com.kajih.practice10_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomQueue implements IQueue {

    private final Random RAND = new Random();
    private List<String> list = new ArrayList<>();

    @Override
    public void push(String data) {
        list.add(data);
    }

    @Override
    public String pop() {
        int elements = RAND.nextInt(list.size());
        String data = list.get(elements);

        list.remove(elements);

        return data;
    }

}