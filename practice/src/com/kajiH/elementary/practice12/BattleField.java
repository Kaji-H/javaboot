package com.kajiH.elementary.practice12;

import java.util.Random;

public class BattleField {
    public static void main(String[] args) {
        showStartProcess();

        String[] players = { "山本", "浜田", };
        Random rand = new Random();

        attackProcess(players, rand);

        showEndProcess();
    }

    private static void attackProcess(String[] players, Random rand) {
        for (int i = 1; i <= 5; i++) {
            int randomIndex = rand.nextInt(2);
            String attackerName = players[randomIndex];
            String defenderName = players[Math.abs(randomIndex - 1)];

            System.out.printf("ターン %d: %n", i);
            System.out.printf("%s が %s を攻撃した. %n", attackerName, defenderName);
            System.out.println();
        }
    }

    private static void showStartProcess() {
        System.out.println("-----");
        System.out.println("処理をスタートします");
        System.out.println("-----");
    }

    private static void showEndProcess() {
        System.out.println("-----");
        System.out.println("処理を終わります");
        System.out.println("-----");
    }
}
