package com.kajih.practice19;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice19.Config.Message;

public class UnpopulatedIsland {

    private Message MESSAGE = new Config().new Message();

    private int days;
    private Player player;
    private List<String> log = new ArrayList<>();

    public UnpopulatedIsland(Player player) {
        this.player = player;
        this.days = 0;
    }

    public void showPrologue() {
        System.out.printf(MESSAGE.PROLOGUE);
    }

    public void spend() {
        this.days++;

        showFood(food);

        String select = selectPlayer();

    }

    public void showEnding() {
        System.out.printf(MESSAGE.ENDING);
    }

    public void showLog() {
        for (String line : log) {
            System.out.println(line);
        }
    }

}
