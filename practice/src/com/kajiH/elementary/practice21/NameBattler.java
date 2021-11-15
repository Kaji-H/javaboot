package com.kajiH.elementary.practice21;

import java.util.Scanner;

public class NameBattler {

    private static Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        BattleField battle = new BattleField();

        battle.generatePlayer(STDIN);

        battle.playBattle();

        battle.showResult();

        STDIN.close();
    }

}
