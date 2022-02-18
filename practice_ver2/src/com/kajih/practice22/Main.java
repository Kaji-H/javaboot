package com.kajih.practice22;

public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        CatchingGameField field = new CatchingGameField();

        // プロローグ
        field.prologue();

        // ゲーム
        field.play(player);

        // リザルト
        field.result();
    }

}
