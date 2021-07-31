package com.kajiH.elementary.practice1;

public class PriceCalculator {
    public static void main(String[] args) {

        int itemPrice = 9800;
        int quantity = 580;
        Order order = new Order(itemPrice, quantity);
        int wholePrice = order.calcWholePrice();
        System.out.printf("%d 円の商品を %d 個注文 => %d 円（税込）%n", itemPrice, quantity,
                wholePrice);
    }
}

class Order {
    private static final double SHIPPING_RATE = 0.1;
    private static final int MAX_SHIPPING_FEE = 10000;

    private static final int BODER_QUANTITY = 500;
    private static final double DISCOUNT = 0.05;
    private static final double TAX = 1.10;

    private static final int MIN_TAX = 0;

    private int itemPrice;
    private int quantity;

    public Order(int itemPrice, int quantity) {
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    public int calcWholePrice() {
        double totalFee = (this.itemPrice * this.quantity - volumeDiscount())
                * TAX;

        return Long.valueOf(Math.round(totalFee + shippingFee())).intValue();
    }

    private double volumeDiscount() {
        System.out.println(Math.max(MIN_TAX, this.quantity - BODER_QUANTITY));

        if (isOverBoderQuantity(this.quantity)) {
            return this.itemPrice * DISCOUNT;
        }

        return this.itemPrice;
    }

    private boolean isOverBoderQuantity(int quantity) {
        return quantity > BODER_QUANTITY;
    }

    private double shippingFee() {
        return Math.min(this.itemPrice * this.quantity * SHIPPING_RATE,
                MAX_SHIPPING_FEE);
    }
}