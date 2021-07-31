package com.kajiH.manual.practice0254;

public class Main {
    public static void main(String[] args) {
        Customer yamamoto = new Customer("山本一郎", 200);
        Customer yamada = new Customer("山田太郎", 300);

        yamamoto.pay();
        yamamoto.showMessageOfPaid();

        yamada.showMessageOfPaid();
    }
}
