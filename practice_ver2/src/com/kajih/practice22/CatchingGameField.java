package com.kajih.practice22;

import java.util.List;

import com.kajih.practice22.monsters.Monster;
import com.kajih.practice22.monsters.MonstersGroup;
import com.kajih.practice22.config.ActionType;

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
        Monster monster = this.monsters.appearance();
        this.appearanceCounter++;

        System.out.printf("%s が現れた\n", monster.getName());
        monster.showStatus();

        while (!isGone(monster)) {

            this.player.SelectCatchOrRelease();

            if (player.getActionPattern() == ActionType.RELEASE) {
                System.out.printf("%s を見逃した\n\n", monster.getName());
                break;
            }

            if (!monster.canCaptured(player.throwCaptureBall())) {
                System.out.printf("ああ、%s がボールから出てきた\n", monster.getName());
                continue;
            }

            player.catchMonster(monster);

            System.out.printf("%s を捕まえた\n\n", monster.getName());

            monster = null;
        }

        System.out.printf("\n");

        if (appearanceCounter < 3 && player.hasBall()) {
            play();
        }

        return;
    }

    private boolean isGone(Monster monster) {
        return monster == null;
    }

    public void result() {
        List<Monster> catchMonsters = player.getCatchMonstersList();

        int score = calScore(catchMonsters);

        System.out.printf("~ 結果 ~\n");
        System.out.printf("捕獲 %d 匹 : スコア %d 点\n", catchMonsters.size(), score);
        System.out.printf("\n");
        for (Monster monster : player.getCatchMonstersList()) {
            monster.showStatus();
        }

        player.goHome();
    }

    private int calScore(List<Monster> catchMonsters) {
        int sumScore = 0;

        for (Monster monster : catchMonsters) {
            sumScore += monster.calScore();
        }

        return sumScore;
    }

}
