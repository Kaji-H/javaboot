package com.kajih.practice22.monsters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.kajih.practice22.config.type.MonsterType;

public class MonstersGroup {

    private Random RAND = new Random();

    private List<Monster> monsters = new ArrayList<>();
    private int sumAppearanceRate = 0;

    public MonstersGroup() {
        for (MonsterType monster : MonsterType.values()) {
            for (int i = 0; i < monster.getAppearanceRate(); i++) {
                monsters.add(new Monster(monster));
            }

            sumAppearanceRate += monster.getAppearanceRate();
        }
    }

    public Monster appearance() {
        int elements = RAND.nextInt(sumAppearanceRate);

        return monsters.get(elements);
    }
}
