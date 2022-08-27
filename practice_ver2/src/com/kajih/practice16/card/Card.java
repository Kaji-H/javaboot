package com.kajih.practice16.card;

import com.kajih.practice16.card.CardType.FaceCards;
import com.kajih.practice16.card.CardType.Mark;

public class Card {
    private int num;
    private Mark mark;

    public Card(int num, Mark mark) {
        this.num = num;
        this.mark = mark;
    }

    public int getNum() {
        return this.num;
    }

    public Mark getMark() {
        return this.mark;
    }

    public String getFaceCardName() {
        return FaceCards.getNameOf(this.num);
    }
}
