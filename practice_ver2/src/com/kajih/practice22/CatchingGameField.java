package com.kajih.practice22;

import java.util.List;

import com.kajih.practice22.config.MonsterType;
import com.kajih.practice22.monsters.Monster;
import com.kajih.practice22.monsters.MonstersGroup;

public class CatchingGameField {

    private Player player = new Player();
    private MonstersGroup monsters = new MonstersGroup();
    private int appearanceCounter;

    public CatchingGameField() {
        appearanceCounter = 0;
    }

    public void prologue() {
        System.out.printf("aaa");
    }

    public void play() {
        Monster monster = monsters.appearance();
        appearanceCounter++;

        System.out.printf("%s が現れた\n", monster.getName());
        monster.showStatus();

        player.CatchOrRelease(monster);

        if (appearanceCounter < 10) {
            play();
        }

        return;
    }

    public void result() {
        List<Monster> catchMonsters = player.getCatchMonstersList();

        int score = calScore(catchMonsters);

        System.out.printf("%d 匹捕獲 : スコア %d 点", catchMonsters.size(), score);
    }

    private int calScore(List<Monster> catchMonsters) {
        int sumScore = 0;

        for (Monster monster : catchMonsters) {
            sumScore += monster.calScore();
        }

        return sumScore;
    }

}
