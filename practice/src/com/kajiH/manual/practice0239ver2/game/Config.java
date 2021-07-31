package com.kajiH.manual.practice0239ver2.game;

public class Config {

    // 基準となる値
    private static final int STANDARD_CHARRENGE_TIME = 5;
    private static final int STANDARD_RANDOM_RANGE = 10;

    private int level = 1;
    private int maxCharrengeTime;
    private int maxRandomRange;

    public Config() {
        setting(level);
    }

    public Config(int level) {
        setting(level);
    }

    public int getLevel() {
        return level;
    }

    public int getMaxCharrengeTime() {
        return maxCharrengeTime;
    }

    public int getMaxRandomRange() {
        return maxRandomRange;
    }

    public void setting(int level) {
        this.level = level;
        this.maxCharrengeTime = STANDARD_CHARRENGE_TIME * level;
        this.maxRandomRange = (int) Math.pow(STANDARD_RANDOM_RANGE, level);
    }
}
