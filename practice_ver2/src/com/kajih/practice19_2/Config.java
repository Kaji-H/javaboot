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

        public static final String EAT = "食べる";
        public static final String NOT_EAT = "食べない";
        public static final String HINT = "ヒント";
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
