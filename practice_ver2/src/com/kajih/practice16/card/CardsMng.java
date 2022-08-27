package com.kajih.practice16.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import com.kajih.practice16.card.CardType.Mark;

public class CardsMng {

    private final int MAX_MARK_NUM = 4;
    private final int MAX_CARDS_NUM = 13;
    private final int MIN_CARDS_NUM = 1;

    private List<Card> cards = new ArrayList<>();

    public CardsMng() {
        setCards();
    }

    public int getNumOfCards() {
        return cards.size();
    }

    public void reset() {
        cards = new ArrayList<>();
        setCards();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        Card card = cards.get(0);
        cards.remove(0);

        return card;
    }

    private void setCards() {

        for (int i = 0; i < MAX_MARK_NUM; i++) {
            for (int j = MIN_CARDS_NUM; j <= MAX_CARDS_NUM; j++) {
                cards.add(new Card(j, Mark.toEnum(i)));
            }
        }
    }
}
