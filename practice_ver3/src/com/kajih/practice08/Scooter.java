package com.kajih.practice08;

public class Scooter implements Bike {

    Engine engine;
    private int maxSpeed;
    private String color;

    Scooter() {
        engine = new Engine();
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void showBikeInfo() {
        System.out.printf("バイクの色: %s, 最高速度: %dkm\n", this.color, this.maxSpeed);
    }

    public void driveStart() {
        engine.start();
    }

    public void driveStop() {
        engine.stop();
    }

}