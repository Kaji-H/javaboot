package com.kajih.practice22.config.type;

public enum MonsterType {
    ZACOMON("ザコモン", 30, 20, 20, 30, 72),
    FUTUMON("フツモン", 50, 20, 30, 30, 50),
    TUYOMON("ツヨモン", 100, 50, 30, 25, 28),
    BOSUMON("ボスモン", 100, 50, 50, 10, 25),
    REAMON("レアモン", 150, 100, 100, 5, 14);

    private String name;
    private int hp;
    private int atk;
    private int def;
    private int appearanceRate;
    private int captureRate;

    MonsterType(String name, int hp, int atk, int def, int appearanceRate, int captureRate) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.appearanceRate = appearanceRate;
        this.captureRate = captureRate;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getAppearanceRate() {
        return appearanceRate;
    }

    public int getCaptureRate() {
        return captureRate;
    }

}
