package com.kajiH.elementary.practice21;

public class Status {

    private static final int[] MAX_RANGE = { 200, 100, 50, 50 };
    private static final int[] MIN_RANGE = { 100, 20, 20, 1 };
    private static final int HP = 0;
    private static final int ATK = 1;
    private static final int DEF = 2;
    private static final int LUCK = 3;
    private static final int MAX_STATUS_TYPES = 4;

    private int[] status = new int[MAX_STATUS_TYPES];
    private HashDigest hash = new HashDigest();

    public Status(String name) {
        for (int i = 0; i < MAX_STATUS_TYPES; i++) {
            this.status[i] = generateStatus(name, i);
        }
    }

    public int getHp() {
        return this.status[HP];
    }

    public void setHp(int hp) {
        this.status[HP] = hp;
    }

    public int getAtk() {
        return this.status[ATK];
    }

    public int getDef() {
        return this.status[DEF];
    }

    public int getLuck() {
        return this.status[LUCK];
    }

    private int generateStatus(String name, int i) {
        double rate = this.hash.generateNumber(name, i) / 255.0;
        int value = (int) ((MAX_RANGE[i] - MIN_RANGE[i]) * rate) + MIN_RANGE[i];

        return value;
    }

}
