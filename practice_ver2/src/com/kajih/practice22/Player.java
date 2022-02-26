package com.kajih.practice22;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice22.captureBalls.CaptureBallsBag;
import com.kajih.practice22.monsters.Monster;

public class Player {

    private CaptureBallsBag balls = new CaptureBallsBag();
    private List<Monster> catchMonsters = new ArrayList<>();

    public List<Monster> getCatchMonstersList() {
        return catchMonsters;
    }

    public void CatchOrRelease(Monster monster) {
        System.out.printf("捕まえる 逃す");

        if (doLetEscape()) {
            return;
        }

    }

}
