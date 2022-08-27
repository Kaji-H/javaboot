package com.kajih.practice18.Config;

public enum FoodingType {
    HERBIVORE("草食"),
    CARNIVORE("肉食");

    private String foodingType;

    FoodingType(String foodingType) {
        this.foodingType = foodingType;
    }

    public String getString() {
        return this.foodingType;
    }
}
