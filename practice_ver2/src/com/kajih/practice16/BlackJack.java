package com.kajih.practice16;

import java.util.ArrayList;
import java.util.List;

import com.kajih.practice16.card.Card;
import com.kajih.practice16.card.CardType.FaceCards;
import com.kajih.practice16.card.CardsMng;

public class BlackJack {

    private static final int TEN_POINTS = 10;
    private static final int MAX_ACE_POINTS = 11;
    private static final int MIN_ACE_POINTS = 1;
    private static final int BLACKJACK = 21;

    public static void main(String[] args) {
        List<Card> hands = new ArrayList<>();
        CardsMng mng = new CardsMng();

        mng.shuffle();

        hands.add(mng.draw());
        hands.add(mng.draw());

        System.out.println(hands.get(0).getNum() + " " + hands.get(1).getNum());

        int score = calBlackJackScore(hands);

        System.out.println("点数:" + score);

    }

    private static int calBlackJackScore(List<Card> hands) {
        int score = 0;
        int countAce = 0;

        for (Card card : hands) {
            if (isAce(card.getNum())) {
                score += MAX_ACE_POINTS;
                countAce++;
            }

            if (isTenPoints(card.getNum())) {
                score += TEN_POINTS;
            }

            if (isNomalScore(card.getNum())) {
                score += card.getNum();
            }

            if (mustSelectAceScore(score, countAce)) {
                int difference = MAX_ACE_POINTS - MIN_ACE_POINTS;

                score -= difference;
                countAce--;
            }
        }

        return score;
    }

    private static boolean mustSelectAceScore(int score, int countAce) {
        return score > BLACKJACK && countAce > 0;
    }

    private static boolean isNomalScore(int num) {
        return num > FaceCards.ACE.getNum() && num < FaceCards.JACK.getNum();
    }

    private static boolean isTenPoints(int num) {
        return num >= FaceCards.JACK.getNum() && num <= FaceCards.KING.getNum();
    }

    private static boolean isAce(int num) {
        return num == FaceCards.ACE.getNum();
    }
}
