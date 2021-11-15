package com.kajiH.elementary.practice21;

import java.util.Random;

public class Chara {

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

    public int attack() {
        return RAND.nextInt(3) + 1;
    }

    public void defence(int damage) {
        int currentHp = this.status.getHp() - damage;

        if (currentHp <= 0) {
            currentHp = 0;
            this.isDeth = true;
        }

        this.status.setHp(currentHp);
    }

    public void showCurrentHp() {
        System.out.printf("%s （ HP %d ）\n", this.name, this.status.getHp());
    }

    public void showStatus() {
        System.out.printf("NAME:%s HP:%d\n", this.name, this.status.getHp());
    }

    public boolean isDeth() {
        return this.isDeth;
    }

}
