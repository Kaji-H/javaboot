package com.kajih.practice22;

public class Main {

    public static void main(String[] args) {

        CatchingGameField field = new CatchingGameField();

        // プロローグ
        field.prologue();

        // ゲーム
        field.play();

        // リザルト
        field.result();
    }

}
