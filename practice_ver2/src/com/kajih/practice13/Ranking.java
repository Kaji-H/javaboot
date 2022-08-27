package com.kajih.practice13;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

    private static final String MESSAGE_RANKING_OF_POINT = "%d 位: %d\n";
    private static final String MESSAGE_RANKING_OF_POINT_AND_NAME = "%d 位: %s %d\n";

    private List<Integer> pointList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();

    public void entryScore(int point) {
        for (int i = 0; i < pointList.size(); i++) {
            if (pointList.get(i) < point) {
                pointList.add(i, point);
                return;
            }
        }
        pointList.add(point);
    }

    public void entryScore(int point, String name) {
        for (int i = 0; i < pointList.size(); i++) {
            if (pointList.get(i) < point) {
                pointList.add(i, point);
                nameList.add(i, name);
                return;
            }
        }
        pointList.add(point);
        nameList.add(name);
    }

    public void printRanking() {
        if (nameList.size() == 0) {
            printRankingOfPoint();
            return;
        }
        printRankingOfPointAndName();
    }

    private void printRankingOfPoint() {
        for (int i = 0; i < pointList.size(); i++) {
            int rank = i + 1;
            System.out.printf(MESSAGE_RANKING_OF_POINT, rank, pointList.get(i));
        }
    }

    private void printRankingOfPointAndName() {
        for (int i = 0; i < pointList.size(); i++) {
            int rank = i + 1;
            System.out.printf(MESSAGE_RANKING_OF_POINT_AND_NAME, rank, nameList.get(i), pointList.get(i));
        }
    }

}
