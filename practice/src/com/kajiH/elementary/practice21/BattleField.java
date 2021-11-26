package com.kajiH.elementary.practice21;

import java.util.Scanner;

public class BattleField {

    private static final String MESSAGE_THAT_WINNER = "%s の勝利！！\n";
    private static final String MESSAGE_THAT_ENTER_PLAYER_NAME = "プレイヤー %d の名前を入力してください：";
    private static final String MESSAGE_THAT_ATTENTION_BLANK_NAME = "名前が入力されていません：";
    private static final String MESSAGE_BATTLE_START = "＝＝＝バトル開始＝＝＝\n";
    private static final String MESSAGE_NEXT_TURN = "ー　次のターン　ー\n";
    private static final String MESSAGE_THAT_ATTACK = "%s の攻撃\n";
    private static final String MESSAGE_THAT_CRITICAL_HIT = "会心の一撃！\n";
    private static final String MESSAGE_THAT_DAMAGE = "%s に %d ダメージ\n";
    private static final String MESSAGE_THAT_DETH = "%s は力尽きた・・・\n";

    private static final String NO_NAME = "-";
    private static final int NUM_OF_PLAYERS = 2;
    private static final int INIT_TURN = 0;
    private static final int FIRST_TURN = 1;

    private Chara[] players;

    public BattleField() {
        this.players = new Chara[NUM_OF_PLAYERS];
    }

    public void generatePlayer(Scanner stdin) {
        for (int i = 0; i < this.players.length; i++) {
            showMessageThatEnterPlayerName(i + 1);

            String name = inputName(stdin);
            this.players[i] = new Chara(name);
        }

        showBlankLine();

        for (Chara player : players) {
            player.showStatus();
        }

        showBlankLine();
    }

    public void playBattle() {
        int turn = INIT_TURN;

        while (isAlive(this.players)) {
            turn++;

            showMessageThatTurn(this.players, turn);

            playAttackAction(this.players);

            showBlankLine();
        }
    }

    public void showResult() {
        String winner = decideWinner(this.players);

        System.out.printf(MESSAGE_THAT_WINNER, winner);
    }

    private String inputName(Scanner stdin) {
        String name = stdin.nextLine();

        name = validate(name, stdin);

        return name;
    }

    private String validate(String name, Scanner stdin) {
        if (name.isBlank()) {
            showMessageThatAttentionBlankName();
            return inputName(stdin);
        }

        return name;
    }

    private void playAttackAction(Chara[] players) {
        for (int i = 0; i < players.length; i++) {
            int attacker = i;
            int defender = (i + 1) % players.length;

            showMessageThatAttack(players[attacker]);
            int damage = players[attacker].attack(players[defender].getStatus().getDef());

            if (isCriticalHit(players[attacker], damage)) {
                showMessageThatCriticalHit();
            }

            showMessageThatDamage(players[defender], damage);
            players[defender].defence(damage);

            if (players[defender].isDeth()) {
                showMessageThatDeth(players[defender]);
                return;
            }
        }
        return;
    }

    private String decideWinner(Chara[] players) {
        String winner = NO_NAME;

        for (Chara player : players) {
            if (player.isDeth()) {
                continue;
            }
            winner = player.getName();
        }

        return winner;
    }

    private void showBlankLine() {
        System.out.println();
    }

    private void showMessageThatEnterPlayerName(int playerNo) {
        System.out.printf(MESSAGE_THAT_ENTER_PLAYER_NAME, playerNo);
    }

    private void showMessageThatAttentionBlankName() {
        System.out.printf(MESSAGE_THAT_ATTENTION_BLANK_NAME);
    }

    private void showMessageThatTurn(Chara[] players, int turn) {
        if (isFirstTurn(turn)) {
            System.out.printf(MESSAGE_BATTLE_START);
            return;
        }

        System.out.printf(MESSAGE_NEXT_TURN);

        for (Chara player : players) {
            player.showCurrentHp();
        }

        showBlankLine();
    }

    private void showMessageThatCriticalHit() {
        System.out.printf(MESSAGE_THAT_CRITICAL_HIT);
    }

    private void showMessageThatAttack(Chara player) {
        System.out.printf(MESSAGE_THAT_ATTACK, player.getName());
    }

    private void showMessageThatDamage(Chara player, int damage) {
        System.out.printf(MESSAGE_THAT_DAMAGE, player.getName(), damage);
    }

    private void showMessageThatDeth(Chara player) {
        System.out.printf(MESSAGE_THAT_DETH, player.getName());
    }

    private boolean isAlive(Chara[] players) {
        for (Chara player : players) {
            if (player.isDeth()) {
                return false;
            }
        }
        return true;
    }

    private boolean isFirstTurn(int turn) {
        return turn == FIRST_TURN;
    }

    private boolean isCriticalHit(Chara chara, int damage) {
        return chara.getStatus().getAtk() <= damage;
    }

}
