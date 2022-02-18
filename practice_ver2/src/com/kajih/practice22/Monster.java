package com.kajih.practice22;

import com.kajih.practice22.config.MonsterType;

public class Monster {

    private String name;
    private int hp;
    private int atk;
    private int def;
    private int appearanceRate;
    private int captureRate;

    public Monster(MonsterType monster) {
        this.name = monster.getName();
        this.hp = monster.getHp();
        this.atk = monster.getAtk();
        this.def = monster.getDef();
        this.appearanceRate = monster.getAppearanceRate();
        this.captureRate = monster.getCaptureRate();
    }

    public int getAppearanceRate() {
        return this.appearanceRate;
    }

    public int getCaptureRate() {
        return this.captureRate;
    }

    public void showStatus() {
        System.out.printf("%s HP:%d ATK:%d DEF:%d\n",
                this.name, this.hp, this.atk, this.def);
    }

    public int calScore() {
        int score = this.hp + this.atk + this.def;
        return score;
    }

    public boolean canCaptured(int percentage) {

        return true;
    }
}
