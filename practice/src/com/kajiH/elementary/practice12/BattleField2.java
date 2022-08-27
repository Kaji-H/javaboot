package com.kajiH.elementary.practice12;

import java.util.Random;

public class BattleField2 {
    static Random rand = new Random();

    public static void main(String[] args) {
        showProcessWithLine("処理をスタートします");

        String[] players = { "山本", "浜田", };

        for (int i = 1; i <= 5; i++) {

            String attackerName = getRandomAttacker(players);
            String defenderName = getDefender(players, attackerName);

            showTurn(i);
            showMessageThatAttack(attackerName, defenderName);

            System.out.println();
        }
        showProcessWithLine("処理を終わります");
    }

    private static String getDefender(String[] players, String attackerName) {
        if (players[0].equals(attackerName)) {
            return players[1];
        }

        return players[0];
    }

    private static String getRandomAttacker(String[] players) {
        int randomIndex = rand.nextInt(2);

        return players[randomIndex];
    }

    private static void showTurn(int i) {
        System.out.printf("ターン %d: %n", i);
    }

    private static void showMessageThatAttack(String attackerName, String defenderName) {
        System.out.printf("%s が %s を攻撃した. %n", attackerName, defenderName);
    }

    private static void showProcessWithLine(String message) {
        System.out.println("-----");
        System.out.println(message);
        System.out.println("-----");
        System.out.println();
    }
}
