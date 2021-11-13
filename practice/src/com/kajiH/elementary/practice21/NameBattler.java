package com.kajiH.elementary.practice21;

import java.util.Scanner;

public class NameBattler {

    private static final String NO_NAME = "-";
    private static final int NUM_OF_PLAYERS = 2;
    private static final int INIT_TURN = 0;
    private static Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        Chara[] players = new Chara[NUM_OF_PLAYERS];

        generatePlayer(players);

        playBattle(players);

        showResult(players);

        STDIN.close();
    }

    private static void generatePlayer(Chara[] players) {
        for (int i = 0; i < players.length; i++) {
            showMessageThatEnterPlayerName(i + 1);

            String name = inputName();
            players[i] = new Chara(name);
        }

        showBlankLine();
    }

    private static String inputName() {
        String name = STDIN.nextLine();

        name = validate(name);

        return name;
    }

    private static String validate(String name) {
        if (name.isBlank()) {
            showMessageThatAttentionBlankName();
            return inputName();
        }

        return name;
    }

    private static void playBattle(Chara[] players) {
        int turn = INIT_TURN;

        while (isAlive(players)) {
            turn++;

            showMessageThatTurn(players, turn);

            playAttackAction(players);

            showBlankLine();
        }
    }

    private static void playAttackAction(Chara[] players) {
        for (int i = 0; i < players.length; i++) {
            int attackerElements = i;
            int defenderElements = (i + 1) % players.length;

            showMessageThatAttack(players[attackerElements]);
            int damage = players[attackerElements].attack();

            showMessageThatDamage(players[defenderElements], damage);
            players[defenderElements].defence(damage);

            if (players[defenderElements].isDeth()) {
                showMessageThatDeth(players[defenderElements]);
                return;
            }
        }
        return;
    }

    private static String decideWinner(Chara[] players) {
        String winner = NO_NAME;

        for (Chara player : players) {
            if (player.isDeth()) {
                continue;
            }
            winner = player.getName();
        }

        return winner;
    }

    private static void showBlankLine() {
        System.out.println();
    }

    private static void showMessageThatEnterPlayerName(int playerNo) {
        System.out.printf("プレイヤー %d の名前を入力してください：", playerNo);
    }

    private static void showMessageThatAttentionBlankName() {
        System.out.printf("名前が入力されていません\n");
    }

    private static void showMessageThatTurn(Chara[] players, int turn) {
        if (isFirstTurn(turn)) {
            System.out.printf("＝＝＝バトル開始＝＝＝\n");
            return;
        }

        System.out.printf("ー　次のターン　ー\n");

        for (Chara player : players) {
            player.showCurrentHp();
        }

        showBlankLine();
    }

    private static void showMessageThatAttack(Chara player) {
        System.out.printf("%s の攻撃\n", player.getName());
    }

    private static void showMessageThatDamage(Chara player, int damage) {
        System.out.printf("%s に %d ダメージ\n", player.getName(), damage);
    }

    private static void showMessageThatDeth(Chara player) {
        System.out.printf("%s は力尽きた・・・\n", player.getName());
    }

    private static void showResult(Chara[] players) {
        String winner = decideWinner(players);

        System.out.printf("%s の勝利！！\n", winner);
    }

    private static boolean isAlive(Chara[] players) {
        for (Chara player : players) {
            if (player.isDeth()) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFirstTurn(int turn) {
        return turn == 1;
    }

}
