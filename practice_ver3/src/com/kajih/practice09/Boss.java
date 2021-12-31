package com.kajih.practice09;

public class Boss implements Worker {

    private Secretary secretary;

    public void callSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    @Override
    public void work() {
        if (secretary instanceof Secretary) {
            secretary.work();
            return;
        }

        System.out.println("秘書がいません");
    }

}
