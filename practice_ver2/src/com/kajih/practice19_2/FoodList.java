package com.kajih.practice19_2;

public enum FoodList {
    POISONOUS_SNAKE(0, "毒蛇", 15, 30, "毒蛇の毒に負けた…"),
    CANNING(1, "漂流物（缶詰）", 30, 50, "歯では開けられなかった。歯が全部折れて出血死…"),
    DRIFTWOOD(2, "流木", 8, 20, "バイキンだらけだった…"),
    FALLEN_LEAVES(3, "落ち葉", 5, 20, "口の中の水分を全部持っていかれた…"),
    POISONOUS_MUSHROOM(4, "毒々しいキノコ", 10, 30, "笑いが止まらず疲れて死んだ…"),
    COLORFUL_FRUIT(5, "カラフルフルーツ", 5, 30, "種が喉に詰まった…"),
    ;

    private int id;
    private String name;
    private int amountOfRexovery;
    private int dangerLevel;
    private String causeOfDeath;

    private FoodList(int id, String name, int amountOfRecovery, int dangerLevel, String causeOfDeath) {
        this.id = id;
        this.name = name;
        this.amountOfRexovery = amountOfRecovery;
        this.dangerLevel = dangerLevel;
        this.causeOfDeath = causeOfDeath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfRexovery() {
        return amountOfRexovery;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public static FoodList toEnum(int num) {

        for (FoodList food : FoodList.values()) {
            if (food.getId() == num) {
                return food;
            }
        }
        return null;
    }

}
