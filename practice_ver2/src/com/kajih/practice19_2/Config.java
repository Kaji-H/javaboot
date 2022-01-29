package com.kajih.practice19_2;

public class Config {
    public class Message {
        public static final String PROLOGUE = "あなたは目が覚めたら無人島にいた。\n" +
                "目の前に1枚の手紙がある。\n" +
                "手紙にはこう書かれていた....\n" +
                "「%d 日間生き延びたら助けます」\n" +
                "こうして無人島生活が始まった\n";
        public static final String NEWLINE = "\n";
        public static final String DATE = "~ %d 日目 ~\n";
        public static final String FOOD_DATA = "%s   回復量 %d  危険度 %d ％\n";
        public static final String PLAYERS_HP = "あなたの体力は %d です。";
        public static final String EAT_OR_NOT = "食べますか？食べませんか？\n";
        public static final String CHOICES = "%d.%s  ";
        public static final String WARREING_TO_INPUT_NON_NUMERIC = "数字を入力してください\n";
        public static final String WARRNING_TO_INPUT_OUT_OF_CHOICES = "選択肢の数字を入力してください\n";
        public static final String TOMMOROW_FOOD = "明日の食べ物は...\n";

        public static final String EAT = "食べる";
        public static final String NOT_EAT = "食べない";
        public static final String HINT = "ヒント";
    }

    public class PlayersConfig {
        public static final int BASE_HP = 10;
        public static final int MIN_HP = 0;
        public static final int MAX_HP = 100;
        public static final int DECREASED_HP_WHEN_HUNGRY = 10;

        public static final int MAX_RAND_VALUE = 100;

        public static final String INIT_STRING = "";
        public static final String CAUSE_OF_DEATH_BY_HUNGER = "空腹によって死んでしまった...";
    }

    public class GameConfig {
        public static final int MAX_HINT_TIME = 3;

        public static final int INIT_DAYS = 1;
        public static final int MAX_DAYS = 5;

        public static final int MIN_CHOICES = 1;
        public static final int MAX_CHOICES = 3;
        public static final int EAT_NUM = 1;
        public static final int NOT_EAT_NUM = 2;
        public static final int HINT_NUM = 3;
    }

}
