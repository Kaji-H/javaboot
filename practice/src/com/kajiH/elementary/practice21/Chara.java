package com.kajiH.elementary.practice21;

import java.util.Random;

public class Chara {

    private static final int MAX_PERCENTAGE = 100;

    private Random RAND = new Random();

    private Status status;
    private String name;
    private boolean isDeth;

    Chara(String name) {
        this.name = name;
        this.status = new Status(this.name);
        this.isDeth = false;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getName() {
        return this.name;
    }

    public int attack(int enemyDef) {
        if (isLucky()) {
            enemyDef = 0;
        }

        int damage = this.status.getAtk() - enemyDef;

        if (isNoDamage(damage)) {
            damage = 0;
        }

        return damage;
    }

    public void defence(int damage) {
        int currentHp = this.status.getHp() - damage;

        if (!isGreaterThanZero(currentHp)) {
            currentHp = 0;
            this.isDeth = true;
        }

        this.status.setHp(currentHp);
    }

    public void showCurrentHp() {
        System.out.printf("%s （ HP %d ）\n", this.name, this.status.getHp());
    }

    public void showStatus() {
        System.out.printf("NAME:%s HP:%d ATK:%d DEF:%d LUCK:%d\n", this.name, this.status.getHp(), this.status.getAtk(),
                this.status.getDef(), this.status.getLuck());
    }

    public boolean isLucky() {
        return this.status.getLuck() >= RAND.nextInt(MAX_PERCENTAGE);
    }

    public boolean isDeth() {
        return this.isDeth;
    }

    private boolean isNoDamage(int damage) {
        return damage < 0;
    }

    private boolean isGreaterThanZero(int hp) {
        return hp > 0;
    }

}
