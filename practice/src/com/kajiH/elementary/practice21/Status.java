package com.kajiH.elementary.practice21;

public class Status {

    private int hp;
    private int atk;
    private int def;
    private int luck;

    public Status(String name) {
        this.hp = 10;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getLuck() {
        return luck;
    }

}
