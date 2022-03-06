package com.kajih.practice22;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice22.input.Inputter;
import com.kajih.practice22.captureBalls.CaptureBall;
import com.kajih.practice22.captureBalls.CaptureBallsBag;
import com.kajih.practice22.config.Message;
import com.kajih.practice22.config.type.ActionType;
import com.kajih.practice22.monsters.Monster;

public class Player {

    private CaptureBallsBag balls = new CaptureBallsBag();
    private List<Monster> catchMonsters = new ArrayList<>();
    private Inputter input = new Inputter();
    private ActionType action;
    private int useBallIndex;

    public List<Monster> getCatchMonstersList() {
        return catchMonsters;
    }

    public void goHome() {
        input.close();
    }

    public void SelectCatchOrRelease() {

        showChoices();

        int selectNum = input.numInRange(0, balls.getBalls().size());

        setAction(selectNum);

        if (action == ActionType.CATCH) {
            setUseBall(selectNum);
        }

    }

    public int throwCaptureBall() {
        int rate = balls.getSuccessRateOfCaptureBall(useBallIndex);

        balls.useBall(useBallIndex);

        return rate;
    }

    private void setUseBall(int selectNum) {
        useBallIndex = selectNum;
    }

    private void showChoices() {
        int choicesNum = 0;

        for (CaptureBall ball : this.balls.getBalls()) {
            System.out.printf(Message.CHOICES_FOR_BALL, choicesNum, ball.getName(), ball.getNum());
            choicesNum++;
        }

        System.out.printf(Message.CHOICES_FOR_RELEASE, choicesNum);
    }

    private void setAction(int selectNum) {
        if (selectNum < this.balls.getBalls().size()) {
            action = ActionType.CATCH;
            return;
        }

        action = ActionType.RELEASE;
    }

    public ActionType getActionPattern() {
        return action;
    }

    public boolean hasBall() {
        return balls.getBalls().size() > 0;
    }

    public void catchMonster(Monster monster) {
        this.catchMonsters.add(monster);
    }

}
