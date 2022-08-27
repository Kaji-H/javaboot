package com.kajih.practice14;

public class Initializer {
    private static int staticCounter;

    private int id;
    private String name;
    private int instanceCounter;

    static {
        System.out.printf("Static 初期化ブロックが実行されました\n");
    }

    {
        staticCounter++;
        instanceCounter++;
        id = staticCounter;
    }

    Initializer(String name) {
        this.name = name;
    }

    public void showCounterValue() {
        System.out.printf("[id] %d, [name] %s, [staticCounter] %d, [instanceCounter] %d\n", this.id, this.name,
                staticCounter, this.instanceCounter);
    }
}
