package com.kajih.practice22.config;

public enum BallType {
    NORMAL_BALL(0, "ノーマル捕獲玉", 0),
    SUPER_BALL(1, "スーパー捕獲玉", 20),
    MIRACLE_BALL(2, "ミラクル捕獲玉", 50);

    private int id;
    private int captureRate;

    public int getId() {
        return id;
    }

    BallType(int id, String name, int captureRate) {
        this.id = id;
        this.name = name;
        this.captureRate = captureRate;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public String getName() {
        return name;
    }

    private String name;

}
