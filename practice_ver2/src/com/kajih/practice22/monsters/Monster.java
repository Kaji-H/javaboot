package com.kajih.practice22.monsters;

import java.util.Random;

import com.kajih.practice22.config.type.MonsterType;

public class Monster {

    private Random RAND = new Random();

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

    public String getName() {
        return this.name;
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

    public boolean canCaptured(int captureRateInBall) {
        int sumCaptureRate = this.captureRate + captureRateInBall;

        if (sumCaptureRate < RAND.nextInt(100)) {
            return false;
        }

        return true;
    }
}
