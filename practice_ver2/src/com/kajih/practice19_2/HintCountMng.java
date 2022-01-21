package com.kajih.practice19_2;

public class HintCountMng {

    private int hints;
    private boolean useHints;

    public HintCountMng(int time) {
        this.hints = time;
        this.useHints = true;
    }

    public void use() {
        this.hints--;
    }

    public void resumeCounting() {
        this.useHints = true;
    }

    public void pauseCounting() {
        this.useHints = false;
    }

    public boolean canUse() {
        return this.hints > 0 && this.useHints;
    }

}
