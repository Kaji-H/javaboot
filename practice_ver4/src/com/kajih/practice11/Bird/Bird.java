package com.kajih.practice11.Bird;

public abstract class Bird {
    protected String name;

    Bird(String name) {
        this.name = name;
    }

    abstract public void fly();

    public void showDetails() {
        System.out.println("[Bird] 名前は " + this.name + " です.");
    }
}
