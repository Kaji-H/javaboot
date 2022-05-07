package com.kajih.practice11.Bird;

public class Pigeon extends Bird {

    public Pigeon(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("[Pigeon] " + this.name + " が飛んだ.");
    }

}
