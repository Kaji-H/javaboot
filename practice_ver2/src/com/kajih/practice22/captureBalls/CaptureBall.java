package com.kajih.practice22.captureBalls;

public class CaptureBall {
    private String name;
    private int correctValue;
    private int count;

    CaptureBall(String name, int correctValue, int count) {
        this.name = name;
        this.correctValue = correctValue;
        this.count = count;
    }

    public String getName() {
        return this.name;
    }

    public int getCorrectValue() {
        return this.correctValue;
    }

    public int getCount() {
        return this.count;
    }

    public void use() {
        this.count--;
    }
}
