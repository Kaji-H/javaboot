package com.kajih.practice22;

import java.util.List;

import com.kajih.practice22.config.Message;
import com.kajih.practice22.config.InitConfig.Field;
import com.kajih.practice22.config.type.ActionType;
import com.kajih.practice22.monsters.Monster;
import com.kajih.practice22.monsters.MonstersGroup;

public class CatchingGameField {

    private Player player = new Player();
    private MonstersGroup monsters = new MonstersGroup();
    private int appearanceCounter;
    private int maxAppearanceNum;

    public CatchingGameField() {
        appearanceCounter = Field.INIT_APPEARANCE_COUNT;
        maxAppearanceNum = Field.MAX_APPEARANCE_NUM;
    }

    public void prologue() {
        System.out.printf(Message.PROLOGUE, maxAppearanceNum);
    }

    public void play() {
        Monster monster = this.monsters.appearance();
        this.appearanceCounter++;

        System.out.printf(Message.APPEARANCE_MONSTER, monster.getName());
        monster.showStatus();

        while (!isGone(monster)) {

            this.player.SelectCatchOrRelease();

            if (player.getActionPattern() == ActionType.RELEASE) {
                System.out.printf(Message.RELEASE_MONSTER, monster.getName());
                break;
            }

            if (!monster.canCaptured(player.throwCaptureBall())) {
                System.out.printf(Message.CANNOT_BE_CAPTURED_MONSTER, monster.getName());
                continue;
            }

            player.catchMonster(monster);

            System.out.printf(Message.CAPTURED_MONSTER, monster.getName());

            monster = null;
        }

        System.out.printf(Message.NEW_LINE);

        if (canKeepPlaying()) {
            play();
        }

        return;
    }

    public void result() {
        List<Monster> catchMonsters = player.getCatchMonstersList();

        int score = calScore(catchMonsters);

        System.out.printf(Message.RESULT);
        System.out.printf(Message.SCORE, catchMonsters.size(), score);
        System.out.printf(Message.NEW_LINE);
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

    private boolean canKeepPlaying() {
        return appearanceCounter < maxAppearanceNum && player.hasBall();
    }

    private boolean isGone(Monster monster) {
        return monster == null;
    }

}
