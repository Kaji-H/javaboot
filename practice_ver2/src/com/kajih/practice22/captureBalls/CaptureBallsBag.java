package com.kajih.practice22.captureBalls;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice22.config.BallConfig;
import com.kajih.practice22.config.BallType;

public class CaptureBallsBag {

    List<CaptureBall> balls = new ArrayList<>();

    public CaptureBallsBag() {
        balls.add(new CaptureBall(BallType.NORMAL_BALL, BallConfig.INIT_NORMAL_BALL_NUM));
        balls.add(new CaptureBall(BallType.SUPER_BALL, BallConfig.INIT_SUPER_BALL_NUM));
        balls.add(new CaptureBall(BallType.MIRACLE_BALL, BallConfig.INIT_MIRACLE_BALL_NUM));
    }

    public List<CaptureBall> getBalls() {
        return this.balls;
    }

    public int getSuccessRateOfCaptureBall(int index) {
        return balls.get(index).getSuccessRate();
    }

    public void useBall(int index) {
        balls.get(index).use();

        if (balls.get(index).getNum() == 0) {
            balls.remove(index);
        }
    }
}