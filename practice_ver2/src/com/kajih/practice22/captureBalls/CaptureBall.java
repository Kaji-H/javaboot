package com.kajih.practice22.captureBalls;

import com.kajih.practice22.config.BallType;

public class CaptureBall {
    private String name;
    private int correctValue;
    private int count;

    CaptureBall(BallType ball, int count) {
        this.name = ball.getName();
        this.correctValue = ball.getCaptureRate();
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
