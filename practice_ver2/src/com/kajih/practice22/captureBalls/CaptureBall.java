package com.kajih.practice22.captureBalls;

import com.kajih.practice22.config.BallType;

public class CaptureBall {
    private String name;
    private int successRate;
    private int num;

    CaptureBall(BallType ball, int count) {
        this.name = ball.getName();
        this.successRate = ball.getCaptureSuccessRate();
        this.num = count;
    }

    public String getName() {
        return this.name;
    }

    public int getSuccessRate() {
        return this.successRate;
    }

    public int getNum() {
        return this.num;
    }

    public void use() {
        this.num--;
    }
}
