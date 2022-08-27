package com.kajih.practice13_2;

public class Main {
    public static void main(String[] args) {
        Ranking ranking = new Ranking();

        ranking.entryScore(300, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        ranking.entryScore(100, "name100");
        ranking.entryScore(400, "name400");
        ranking.entryScore(200, "name200");

        ranking.printRanking();
    }
}
