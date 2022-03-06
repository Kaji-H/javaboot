package com.kajih.practice22.captureBalls;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice22.config.InitConfig.VariousBallsNum;
import com.kajih.practice22.config.type.BallType;

public class CaptureBallsBag {

    List<CaptureBall> balls = new ArrayList<>();

    public CaptureBallsBag() {
        balls.add(new CaptureBall(BallType.NORMAL_BALL, VariousBallsNum.NORMAL_BALL));
        balls.add(new CaptureBall(BallType.SUPER_BALL, VariousBallsNum.SUPER_BALL));
        balls.add(new CaptureBall(BallType.MIRACLE_BALL, VariousBallsNum.MIRACLE_BALL));
    }

    public List<CaptureBall> getBalls() {
        return this.balls;
    }

    public int getSuccessRateOfCaptureBall(int index) {
        return balls.get(index).getSuccessRate();
    }

    public void useBall(int index) {
        balls.get(index).use();

        if (!hasBall(balls.get(index))) {
            balls.remove(index);
        }
    }

    private boolean hasBall(CaptureBall ball) {
        return ball.getNum() > 0;
    }
}