package com.kajiH.manual.practice0254;

public class Customer {

    private String name;
    private Register regi;

    public Customer(String name, int money) {
        this.name = name;
        this.regi = new Register(money);
    }

    public void pay() {
        this.regi.pay();
    }

    public void showMessageOfPaid() {
        System.out.printf("%s さんは %d 円", this.name, this.regi.getAmount());

        if (this.regi.getIsPaid()) {
            System.out.printf("支払い済みです。\n");
            return;
        }

        System.out.printf("請求中です。\n");

    }

}
