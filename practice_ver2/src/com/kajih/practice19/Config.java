package com.kajih.practice19;

public class Config {

    public class Message {

        public final String PROLOGUE = "あなたは目が覚めたら無人島にいた。\n" +
                "目の前に1枚の手紙がある。\n" +
                "手紙にはこう書かれていた....\n" +
                "「%d 日間生き延びたら助けます」\n" +
                "こうして無人島生活が始まった\n";
        public final String NEWLINE = "\n";
        public final String DATE = "~ %d 日目 ~\n";
        public final String FOOD_DATA = "%s   回復量 %d  危険度 %d ％\n";
        public final String PLAYERS_HP = "あなたの体力は %d です。";
        public final String EAT_OR_NOT = "食べますか？食べませんか？\n";
        public final String CHOICES_TO_EAT = "1.食べる  2.食べない  ";
        public final String HINT_CHOICES = "3.ヒント  ";
        public final String WARREING_TO_INPUT_NON_NUMERIC = "数字を入力してください\n";
        public final String WARRNING_TO_INPUT_OUT_OF_CHOICES = "選択肢の数字を入力してください\n";
        public final String TOMMOROW_FOOD = "明日の食べ物は...\n";
        public final String BAD_END = "%s\n";
        public final String ENDING = "おめでとう!!\nあなたは %d 日間生き残り、無事に無人島から帰還できました\n";

        public final String RECORD = "%d 日目: HP %d  食べ物 %s  危険度 %d %  アクション %s\n";
        public final String EAT = "食べる";
        public final String NOT_EAT = "食べない";
        public final String LOG = "~ ログ ~\n";
    }

    public class PlayersConfig {
        public final int BASE_HP = 10;
        public final int MIN_HP = 0;
        public final int MAX_HP = 100;
        public final int DECREASED_HP_WHEN_HUNGRY = 10;

        public final int MAX_RAND_VALUE = 100;

        public final String INIT_STRING = "";
        public final String CAUSE_OF_DEATH_BY_HUNGER = "空腹によって死んでしまった...";
    }

    public class GameConfig {
        public final int MIN_HINT_TIME = 0;
        public final int MAX_HINT_TIME = 3;

        public final int INIT_DAYS = 1;
        public final int MAX_DAYS = 5;

        public final int MIN_CHOICES = 1;
        public final int MAX_CHOICES = 3;
        public final int EAT_NUM = 1;
        public final int NOT_EAT_NUM = 2;
        public final int HINT_NUM = 3;
    }
}
