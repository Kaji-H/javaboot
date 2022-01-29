package com.kajih.practice19_2;

import java.util.Random;
import java.util.Scanner;

import com.kajih.practice19_2.Config.PlayersConfig;

public class Player {

    private Random RAND = new Random();

    private Scanner stdin;

    private int hp;
    private String causeOfDeath;

    public Player(Scanner stdin) {
        this.stdin = stdin;
        this.hp = PlayersConfig.BASE_HP;
        this.causeOfDeath = PlayersConfig.INIT_STRING;
    }

    public int getHp() {
        return this.hp;
    }

    public String getCauseOfDeath() {
        return this.causeOfDeath;
    }

    public void recoverHp(int recovery) {
        this.hp += recovery;
    }

    public void decreseHpWhenHungry() {
        this.hp -= PlayersConfig.DECREASED_HP_WHEN_HUNGRY;
        this.causeOfDeath = PlayersConfig.CAUSE_OF_DEATH_BY_HUNGER;
    }

    public void sufferFromFoodPoisoning(String causeOfDeath) {
        this.hp = PlayersConfig.MIN_HP;
        this.causeOfDeath = causeOfDeath;
    }

    public String input() {
        return this.stdin.nextLine();
    }

    public boolean canEat(int dangerLevel) {
        return dangerLevel < RAND.nextInt(PlayersConfig.MAX_RAND_VALUE);
    }

    public boolean isDeath() {
        return this.hp <= PlayersConfig.MIN_HP;
    }

}
