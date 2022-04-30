package com.kajih.practice09.bag;

public class Item {

    public String name;
    private int size;

    public Item(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

}
