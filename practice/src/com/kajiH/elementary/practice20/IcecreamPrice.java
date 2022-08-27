package com.kajiH.elementary.practice20;

public class IcecreamPrice {

    private static final String ICECREAM_CONTENT_FORMAT = "%d 個盛り %s アイスの値段: %.0f 円 %n";

    public static void main(String[] args) {
        IceCream ic = new IceCream();
        ic.flavor = "ピスタチオ";
        ic.numberOfScoops = 2;

        showIcecreamContent(ic);

        FruitSaladWithIceCream fs = new FruitSaladWithIceCream();
        fs.flavor = "チョコレート";
        fs.numberOfScoops = 1;
        fs.gramsOfFruitSalad = 50;

        showFruitSaladWeight(fs);
        showIcecreamContent(fs);

        PancakeWithIceCream pancakeWithIceCream = new PancakeWithIceCream();
        pancakeWithIceCream.flavor = "バニラ";
        pancakeWithIceCream.numberOfScoops = 1;
        pancakeWithIceCream.gramsOfPancake = 75;

        showPancakeWeight(pancakeWithIceCream);
        showIcecreamContent(pancakeWithIceCream);
    }

    private static void showFruitSaladWeight(FruitSaladWithIceCream fs) {
        System.out.printf("%d グラムのフルーツサラダと ", fs.gramsOfFruitSalad);
    }

    private static void showPancakeWeight(PancakeWithIceCream pancakeWithIceCream) {
        System.out.printf("%d グラムのパンケーキと ", pancakeWithIceCream.gramsOfPancake);
    }

    private static void showIcecreamContent(IceCream ic) {
        System.out.printf(ICECREAM_CONTENT_FORMAT, ic.numberOfScoops, ic.flavor, ic.getPrice());
    }
}

class IceCream {
    String flavor;
    int numberOfScoops;
    double pricePerScoop;

    IceCream() {
        this.pricePerScoop = 35.0;
    }

    public double getIceCreamPrice() {
        return pricePerScoop * numberOfScoops;
    }

    public double getPrice() {
        return getIceCreamPrice();
    }
}

class FruitSaladWithIceCream extends IceCream {
    int gramsOfFruitSalad;
    double pricePerGram;

    FruitSaladWithIceCream() {
        super();
        pricePerGram = 0.75;
    }

    public double getFruitSaladPrice() {
        return gramsOfFruitSalad * pricePerGram;
    }

    @Override
    public double getPrice() {
        return getFruitSaladPrice() + getIceCreamPrice();
    }
}

class PancakeWithIceCream extends IceCream {
    int gramsOfPancake;
    double pricePerGram;

    PancakeWithIceCream() {
        super();
        pricePerGram = 1.25;
    }

    public double getPancakePrice() {
        return gramsOfPancake * pricePerGram;
    }

    @Override
    public double getPrice() {
        return getPancakePrice() + getIceCreamPrice();
    }
}
