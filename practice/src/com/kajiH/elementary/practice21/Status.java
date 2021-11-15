package com.kajiH.elementary.practice21;

public class Status {

    private HashDigest hash = new HashDigest();

    private int hp;
    private int atk;
    private int def;
    private int luck;

    public Status(String name) {
        this.hp = hash.generateNumber(name, 1);
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return this.atk;
    }

    public int getDef() {
        return this.def;
    }

    public int getLuck() {
        return this.luck;
    }

}
