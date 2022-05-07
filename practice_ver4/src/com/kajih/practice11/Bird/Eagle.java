package com.kajih.practice11.Bird;

public class Eagle extends Bird {

    public Eagle(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("[Eagle] " + this.name + " が飛んだ.");
    }

}
