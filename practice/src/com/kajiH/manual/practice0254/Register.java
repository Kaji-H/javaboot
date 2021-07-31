package com.kajiH.manual.practice0254;

public class Register {

    private int amount;
    private boolean isPaid;

    public Register(int money) {
        this.amount = money;
        this.isPaid = false;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public int getAmount() {
        return amount;
    }

    public void pay() {
        this.isPaid = true;
    }

}
