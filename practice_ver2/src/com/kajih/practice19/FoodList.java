package com.kajih.practice19;

public enum FoodList {
    POISONOUS_SNAKE("毒蛇", 15, 30, "毒蛇の毒に負けた…"),
    CANNING("漂流物（缶詰）", 30, 50, "歯では開けられなかった。歯が全部折れて出血死…"),
    DRIFTWOOD("流木", 8, 20, "バイキンだらけだった…"),
    FALLEN_LEAVES("落ち葉", 5, 20, "口の中の水分を全部持っていかれた…"),
    POISONOUS_MUSHROOM("毒々しいキノコ", 10, 30, "笑いが止まらず疲れて死んだ…"),
    COLORFUL_FRUIT("カラフルフルーツ", 5, 30, "種が喉に詰まった…"),
    ;

    private String name;
    private int amountOfRexovery;
    private int dangerLevel;
    private String caouseOfDeath;

    private FoodList(String name, int amountOfRecovery, int dangerLevel, String causeOfDeath) {
        this.name = name;
        this.amountOfRexovery = amountOfRecovery;
        this.dangerLevel = dangerLevel;
        this.caouseOfDeath = caouseOfDeath;
    }
}
