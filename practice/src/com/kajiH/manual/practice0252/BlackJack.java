package com.kajiH.manual.practice0252;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    private static final String[] FACE_CARDS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private static final int[] CARD_SCORE = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };
    private static final int CARD_NUM = FACE_CARDS.length;

    private static final double LOSE_RATE = 0;
    private static final double TIE_RATE = 1.0;
    private static final double WIN_RATE = 2.0;
    private static final double BLACK_JACK_RATE = 3.0;

    private static final int MAX_DEALS = 2;

    private static final int MAX_SCORE = 21;
    private static final int ACE_CARD_ELEMENTS = 0;
    private static final int DEALER_SCORE_BODER = 17;

    private static final int ONE_LINE = 1;

    private static final String[] YES_OR_NO = { "Y", "N" };
    private static final int NOT_BET = 0;
    private static final int YES_NUM = 0;

    private static final String WORD_THAT_CORRECT_COIN_HOLDINGS = "現在のコイン数 : %d\n";
    private static final String WORD_THAT_BET_COINS = "%d コイン賭けました\n";
    private static final String WORD_THAT_CAN_NOT_PLAY_GAME = "コインが賭けられていないのでゲームができません\n";
    private static final String WORD_THAT_NO_MORE_COINS = "コインがなくなりました\n";
    private static final String WORD_THAT_NOT_RECEIVE_COINS = "コインの受け取りはありません\n";
    private static final String WORD_THAT_RECEIVE_COINS = "%d コイン受け取った\n";

    private static final String WORD_THAT_BE_DEALT_CARD = "%sに「%s」が配られました\n";
    private static final String WORD_THAT_USER_SCORE = "%sの合計は %d です\n";
    private static final String WORD_THAT_BLACK_JACK = "ブラックジャック！！\n";
    private static final String WORD_THAT_LOSE = "あなたの負けです\n";
    private static final String WORD_THAT_TIE = "引き分けです\n";
    private static final String WORD_THAT_WIN = "あなたの勝ちです\n";

    private static final String WORD_THAT_ASK_IF_YOU_WANT_TO_DRAW_ANOTHER_CARD = "もう1枚カードを引きますか？(Y/N):";
    private static final String WORD_THAT_ASK_IF_YOU_WANT_TO_CONTINUE = "続けて遊びますか？(Y/N):";
    private static final String WORD_THAT_PLEASE_INPUT_YES_OR_NO = "Y または N を入力してください\n";

    private static String playerName = "あなた";
    private static String dealerName = "ディーラー";

    private static Random RAND = new Random();
    private static Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        int myCoins = 100;

        while (hasCoins(myCoins)) {
            showWordThatCorrectCoinHoldings(myCoins);

            int bets = betMyCoins(myCoins);
            myCoins -= bets;

            if (isNotBets(bets)) {
                show(WORD_THAT_CAN_NOT_PLAY_GAME);
                break;
            }

            showWordThatBetCoins(bets);
            showBlankLine(ONE_LINE);

            double dividendRate = playGame();

            showWordThatResult(dividendRate);
            myCoins += receiveCoins(bets, dividendRate);

            if (!hasCoins(myCoins)) {
                show(WORD_THAT_NO_MORE_COINS);
                break;
            }

            boolean isContinue = selectContinue();

            if (!isContinue) {
                break;
            }
        }

    }

    private static int betMyCoins(int myCoins) {
        if (!hasEnoughCoins(myCoins)) {
            return 0;
        }

        return 10;
    }

    private static double playGame() {
        List<String> myHand = new ArrayList<>();
        List<String> dealerHand = new ArrayList<>();

        dealForFirst(myHand, dealerHand);
        showHands(myHand, dealerHand);

        int myScore = calScore(myHand);
        int dealerScore = calScore(dealerHand);

        showScores(myScore, dealerScore);

        if (isOneOfYouBlackJack(myScore, dealerScore)) {
            show(WORD_THAT_BLACK_JACK);
            showBlankLine(ONE_LINE);

            return getBlackJackRate(myScore, dealerScore);
        }

        myScore = getScoreAndSelectHitOrStand(myHand, myScore);

        if (isBust(myScore)) {
            return LOSE_RATE;
        }

        dealerScore = drowsCardsForDealer(dealerHand, dealerScore);

        return getRate(myScore, dealerScore);
    }

    private static void dealForFirst(List<String> hand1, List<String> hand2) {
        for (int i = 0; i < MAX_DEALS; i++) {
            hand1.add(deal());
            hand2.add(deal());
        }
    }

    private static String deal() {
        return FACE_CARDS[RAND.nextInt(CARD_NUM)];
    }

    private static int calScore(List<String> hand) {
        int sumScore = 0;
        int countAce = 0;

        for (String faceCard : hand) {
            sumScore += changeCardsToScore(faceCard);

            if (faceCard.equals(FACE_CARDS[ACE_CARD_ELEMENTS])) {
                countAce++;
            }

            if (isNeedToChangeAce(sumScore, countAce)) {
                sumScore -= 10;
            }
        }

        return sumScore;
    }

    private static int changeCardsToScore(String faceCard) {
        for (int i = 0; i < CARD_NUM; i++) {
            if (faceCard.equals(FACE_CARDS[i])) {
                return CARD_SCORE[i];
            }
        }

        return 0;
    }

    private static double getBlackJackRate(int myScore, int dealerScore) {
        if (isMaxScore(myScore) && !isMaxScore(dealerScore)) {
            return BLACK_JACK_RATE;
        }

        if (isTie(myScore, dealerScore)) {
            return TIE_RATE;
        }

        return LOSE_RATE;
    }

    private static int getScoreAndSelectHitOrStand(List<String> hand, int score) {
        if (isMoreThanMaxScore(score)) {
            return score;
        }

        boolean isHit = selectHitorStand();

        if (isHit) {
            String card = deal();

            hand.add(card);
            showCardOf(playerName, card);

            score = calScore(hand);
            showScore(playerName, score);

            return getScoreAndSelectHitOrStand(hand, score);
        }

        return score;
    }

    private static boolean selectHitorStand() {
        show(WORD_THAT_ASK_IF_YOU_WANT_TO_DRAW_ANOTHER_CARD);

        String yesNo = selectYesOrNo();

        showBlankLine(ONE_LINE);

        return isYes(yesNo);
    }

    private static int drowsCardsForDealer(List<String> hand, int score) {
        if (isMoreThan(DEALER_SCORE_BODER, score)) {
            return score;
        }

        String card = deal();

        hand.add(card);
        showCardOf(dealerName, card);

        score = calScore(hand);
        showScore(dealerName, score);
        showBlankLine(ONE_LINE);

        return drowsCardsForDealer(hand, score);
    }

    private static double getRate(int myScore, int dealerScore) {
        if (isWin(myScore, dealerScore)) {
            return WIN_RATE;
        }

        if (isTie(myScore, dealerScore)) {
            return TIE_RATE;
        }

        return LOSE_RATE;
    }

    private static int receiveCoins(int bets, double rate) {
        int receiveCoins = (int) (bets * rate);

        showReceiveCoins(receiveCoins);

        return receiveCoins;
    }

    private static boolean selectContinue() {

        show(WORD_THAT_ASK_IF_YOU_WANT_TO_CONTINUE);

        String yesNo = selectYesOrNo();

        showBlankLine(ONE_LINE);

        return isYes(yesNo);
    }

    private static String selectYesOrNo() {
        String yesNo = STDIN.nextLine();

        yesNo = vallidate(yesNo);

        return yesNo;
    }

    private static String vallidate(String yesNo) {
        if (!isYesOrNo(yesNo)) {
            show(WORD_THAT_PLEASE_INPUT_YES_OR_NO);
            return selectYesOrNo();
        }

        return yesNo;
    }

    private static void show(String word) {
        System.out.printf(word);
    }

    private static void showWordThatBetCoins(int bets) {
        System.out.printf(WORD_THAT_BET_COINS, bets);
    }

    private static void showWordThatResult(double rate) {
        if (isLoseRate(rate)) {
            show(WORD_THAT_LOSE);
            return;
        }

        if (isTieRate(rate)) {
            show(WORD_THAT_TIE);
            return;
        }

        show(WORD_THAT_WIN);
    }

    private static void showHands(List<String> myCards, List<String> dealerCards) {
        for (int i = 0; i < MAX_DEALS; i++) {
            showCardOf(playerName, myCards.get(i));
            showCardOf(dealerName, dealerCards.get(i));
            // System.out.printf(WORD_THAT_BE_DEALT_MY_CARD, myCards.get(i));
            // System.out.printf(WORD_THAT_BE_DEALT_DEALER_CARD, dealerCards.get(i));
        }

        showBlankLine(ONE_LINE);
    }

    private static void showCardOf(String name, String faceCard) {
        System.out.printf(WORD_THAT_BE_DEALT_CARD, name, faceCard);
    }

    private static void showReceiveCoins(int receiveCoins) {
        if (receiveCoins == 0) {
            show(WORD_THAT_NOT_RECEIVE_COINS);
            return;
        }

        System.out.printf(WORD_THAT_RECEIVE_COINS, receiveCoins);
    }

    private static void showBlankLine(int num) {
        for (int i = 0; i < num; i++) {
            System.out.println();
        }
    }

    private static void showWordThatCorrectCoinHoldings(int myCoins) {
        System.out.printf(WORD_THAT_CORRECT_COIN_HOLDINGS, myCoins);
    }

    private static void showScores(int myScore, int dealerScore) {
        showScore(dealerName, dealerScore);
        showScore(playerName, myScore);
    }

    private static void showScore(String name, int score) {
        System.out.printf(WORD_THAT_USER_SCORE, name, score);
    }

    private static boolean hasCoins(int myCoins) {
        return myCoins > 0;
    }

    private static boolean isNotBets(int bets) {
        return bets == NOT_BET;
    }

    private static boolean isTieRate(double rate) {
        return rate == TIE_RATE;
    }

    private static boolean isLoseRate(double rate) {
        return rate == LOSE_RATE;
    }

    private static boolean isYes(String yesNo) {
        if (yesNo.equals(YES_OR_NO[YES_NUM])) {
            return true;
        }

        return false;
    }

    private static boolean isYesOrNo(String yesNo) {

        for (String str : YES_OR_NO) {
            if (yesNo.equals(str)) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasEnoughCoins(int myCoins) {
        return myCoins >= 10;
    }

    private static boolean isMaxScore(int score) {
        return score == MAX_SCORE;
    }

    private static boolean isOneOfYouBlackJack(int myScore, int dealerScore) {
        return isMaxScore(myScore) || isMaxScore(dealerScore);
    }

    private static boolean isTie(int myScore, int dealerScore) {
        return myScore == dealerScore;
    }

    private static boolean isWin(int myScore, int dealerScore) {
        return isBust(dealerScore) || myScore > dealerScore;
    }

    private static boolean isMoreThan(int scoreBoder, int score) {
        return score > scoreBoder;
    }

    private static boolean isNeedToChangeAce(int sumScore, int countAce) {
        return sumScore > MAX_SCORE && countAce > 0;
    }

    private static boolean isMoreThanMaxScore(int score) {
        return score >= MAX_SCORE;
    }

    private static boolean isBust(int score) {
        return score > MAX_SCORE;
    }

}
