package com.kajih.practice19_2;

import java.util.Scanner;

public class Player {

    private Scanner stdin;

    private int hp;

    public Player(Scanner stdin) {
        this.stdin = stdin;
        this.hp = 50;
    }

    public int getHp() {
        return this.hp;
    }

    public String input() {
        return this.stdin.nextLine();
    }

    public boolean isDeath() {
        return this.hp <= 0;
    }

}
