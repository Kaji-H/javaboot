package com.kajih.practice16.card;

public class CardType {
    public enum Mark {

        DAIAMONDS(0, "ダイヤモンド"),
        HEARTS(1, "ハート"),
        CLUBS(2, "クラブ"),
        SPADES(3, "スペード");

        final int id;
        final String mark;

        private Mark(int id, String mark) {
            this.id = id;
            this.mark = mark;
        }

        public int getId() {
            return this.id;
        }

        public String getMark() {
            return this.mark;
        }

        public static Mark toEnum(int num) {
            for (Mark value : Mark.values()) {
                if (value.getId() == num) {
                    return value;
                }
            }
            return null;
        }

    }

    public enum FaceCards {
        ACE(1, "A"),
        JACK(11, "J"),
        QUEEN(12, "Q"),
        KING(13, "K");

        private int num;
        private String numName;

        private FaceCards(int num, String numName) {
            this.num = num;
            this.numName = numName;
        }

        public int getNum() {
            return this.num;
        }

        public String getNumName() {
            return this.numName;
        }

        public static String getNameOf(int num) {
            for (FaceCards value : FaceCards.values()) {
                if (value.getNum() == num) {
                    return value.getNumName();
                }
            }

            return String.valueOf(num);
        }

    }
}
