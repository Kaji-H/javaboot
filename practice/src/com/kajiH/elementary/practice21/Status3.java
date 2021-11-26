package com.kajiH.elementary.practice21;

public class Status3 {

    private HashDigest hash = new HashDigest();

    private int hp = 0;
    private int atk = 0;
    private int def = 0;
    private int luck = 0;

    public Status3(String name) {
        this.hp = hash.generateNumber(name, 1);
        this.atk = hash.generateNumber(name, 2);
        this.def = hash.generateNumber(name, 3);
        this.luck = hash.generateNumber(name, 4);
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
