package com.kajih.practice09;

public class Company {
    public static void main(String[] args) {
        Secretary secretary = new Secretary();
        Boss bossWithSecretary = new Boss();
        bossWithSecretary.callSecretary(secretary);
        bossWithSecretary.work();
        Boss bossWithNoSecretary = new Boss();
        bossWithNoSecretary.work();
    }
}
