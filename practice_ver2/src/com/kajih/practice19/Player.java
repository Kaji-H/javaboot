package com.kajih.practice19;

import java.util.Random;
import java.util.Scanner;

import com.kajih.practice19.Config.PlayersConfig;

public class Player {

    private PlayersConfig CONFIG = new Config().new PlayersConfig();
    private Random RAND = new Random();

    private int hp;
    private String causeOfDeath;
    private Scanner stdin;

    public Player(Scanner stdin) {
        this.stdin = stdin;
        this.hp = CONFIG.BASE_HP;
        this.causeOfDeath = CONFIG.INIT_STRING;
    }

    public int getHp() {
        return this.hp;
    }

    public String getCauseOfDeath() {
        return this.causeOfDeath;
    }

    public void recoverHp(int amountOfRecovery) {
        this.hp += amountOfRecovery;
    }

    public void decreseHpWhenHungry() {
        this.hp -= CONFIG.DECREASED_HP_WHEN_HUNGRY;
        this.causeOfDeath = CONFIG.CAUSE_OF_DEATH_BY_HUNGER;
    }

    public String input() {
        return this.stdin.nextLine();
    }

    public boolean canEat(int dangerLevel) {
        return dangerLevel < RAND.nextInt(CONFIG.MAX_RAND_VALUE);
    }

    public void sufferFromFoodPoisoning(String causeOfDeath) {
        this.hp = CONFIG.MIN_HP;
        this.causeOfDeath = causeOfDeath;
    }

    public boolean isDeath() {
        return this.hp <= CONFIG.MIN_HP;
    }

}
