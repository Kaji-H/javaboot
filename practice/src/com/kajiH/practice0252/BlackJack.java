package com.kajiH.practice0252;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    private static final String[] FACE_CARDS = { "A", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "J", "Q", "K" };
    private static final int[] CARD_SCORE = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            10, 10, 10 };
    private static final int CARD_NUM = FACE_CARDS.length;

    private static final double LOSE_RATE = 0;
    private static final double TIE_RATE = 1.0;
    private static final double WIN_RATE = 2.0;
    private static final double BLACK_JACK_RATE = 3.0;
    private static final int NOT_BET = 0;
    private static final int YES_NUM = 0;
    private static final int ACE_CARD_ELEMENTS = 0;

    private static final String WORD_THAT_CORRECT_COIN_HOLDINGS = "現在のコイン数 : %d\n";
    private static final String WORD_THAT_BET_COINS = "%d コイン賭けました\n";
    private static final String WORD_THAT_CAN_NOT_PLAY_GAME = "コインが賭けられていないのでゲームができません\n";
    private static final String WORD_THAT_RECEIVE_COINS = "%d コイン受け取った\n";
    private static final String WORD_THAT_LOSE = "あなたの負けです\n";
    private static final String WORD_THAT_TIE = "引き分けです\n";
    private static final String WORD_THAT_WIN = "あなたの勝ちです\n";
    private static final String WORD_THAT_NO_MORE_COINS = "コインがなくなりました\n";
    private static final String WORD_THAT_ASK_IF_YOU_WANT_TO_CONTINUE = "続けて遊びますか？(Y/N):";
    private static final String WORD_THAT_PLEASE_INPUT_YES_OR_NO = "Y または N を入力してください\n";
    private static final String WORD_THAT_SELECT_MENU = "%d : %s\n";
    private static final String BLANK_LINE = "\n";
    private static final String[] YES_OR_NO = { "Y", "N" };
    // 手札
    private static List<String> myHand = new ArrayList<>();
    private static List<String> dealerHand = new ArrayList<>();
    private static int myScore = 0;
    private static int dealerScore = 0;
    private static String playerName = "あなた";
    private static String dealerName = "ディーラー";

    private static Random RAND = new Random();
    private static Scanner STDIN = new Scanner(System.in);
    private static int MAX_DEALS = 2;
    private static String WORD_THAT_BE_DEALT_MY_CARD = "あなたに「%s」が配られました\n";
    private static String WORD_THAT_BE_DEALT_DEALER_CARD = "ディーラーに「%s」が配られました\n";
    private static String WORD_THAT_USER_SCORE = "%sの合計は %d です\n";

    public static void main(String[] args) {
        int myCoins = 100;

        while (hasCoins(myCoins)) {
            showWordThatCorrectCoinHoldings(myCoins);

            int bets = betMyCoins(myCoins);
            myCoins -= bets;

            if (!canPlayGame(bets)) {
                show(WORD_THAT_CAN_NOT_PLAY_GAME);
                break;
            }

            showWordThatBetCoins(bets);
            show(BLANK_LINE);

            double rate = playGame();

            showWordThatResult(bets, rate);
            myCoins += receiveCoins(bets, rate);

            if (!hasCoins(myCoins)) {
                show(WORD_THAT_NO_MORE_COINS);
                break;
            }

            if (!isContinue()) {
                break;
            }
        }

    }

    private static boolean isNoMorCoins(int myCoins) {
        return myCoins == 0;
    }

    private static void showWordThatCorrectCoinHoldings(int myCoins) {
        System.out.printf(WORD_THAT_CORRECT_COIN_HOLDINGS, myCoins);
    }

    private static boolean hasCoins(int myCoins) {
        return myCoins > 0;
    }

    private static boolean canPlayGame(int bets) {
        return bets != NOT_BET;
    }

    private static void show(String word) {
        System.out.printf(word);
    }

    private static void showWordThatBetCoins(int bets) {
        System.out.printf(WORD_THAT_BET_COINS, bets);
    }

    private static void showWordThatResult(int bets, double rate) {
        if (rate == LOSE_RATE) {
            show(WORD_THAT_LOSE);
            return;
        } else if (rate == TIE_RATE) {
            show(WORD_THAT_TIE);
        } else {
            show(WORD_THAT_WIN);
        }

        int receiveCoins = (int) (bets * rate);
        System.out.printf(WORD_THAT_RECEIVE_COINS, receiveCoins);

    }

    private static boolean isContinue() {

        show(WORD_THAT_ASK_IF_YOU_WANT_TO_CONTINUE);

        String yesNo = selectYesOrNo();

        show(BLANK_LINE);

        return isYes(yesNo);
    }

    private static boolean isYes(String yesNo) {
        if (yesNo.equals(YES_OR_NO[YES_NUM])) {
            return true;
        }

        return false;
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

    private static boolean isYesOrNo(String yesNo) {

        for (String str : YES_OR_NO) {
            if (yesNo.equals(str)) {
                return true;
            }
        }

        return false;
    }

    private static int betMyCoins(int myCoins) {
        if (!hasEnoughCoins(myCoins)) {
            return 0;
        }

        return 10;
    }

    private static boolean hasEnoughCoins(int myCoins) {
        return myCoins >= 10;
    }

    private static double playGame() {

        deal(myHand, dealerHand);
        showHands(myHand, dealerHand);

        myScore = calScore(myHand);
        dealerScore = calScore(dealerHand);

        showScores(myScore, dealerScore);

        if (isBlackJack(myHand)) {
            return BLACK_JACK_RATE;
        }

        if (isBlackJack(dealerHand)) {
            return LOSE_RATE;
        }

        myScore = selectHitOrStand(myHand, myScore);

        if (isBust(myScore)) {
            return LOSE_RATE;
        }

        drowsCardsForDealer(dealerHand, dealerScore);

        return judgeRate(myScore, dealerScore);
    }

    private static double judgeRate(int myScore, int dealerScore) {
        return 0;
    }

    private static void drowsCardsForDealer(List<String> dealerHand2,
            int dealerScore2) {}

    private static int calScore(List<String> hand) {
        int sumScore = 0;
        int countAce = 0;

        for (String faceCard : hand) {
            sumScore += changeCardsToScore(faceCard);

            if (faceCard.equals(FACE_CARDS[ACE_CARD_ELEMENTS])) {
                countAce++;
            }

            if (sumScore > 21 && countAce > 0) {
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

    private static void showScores(int myScore, int dealerScore) {
        showScore(dealerName, dealerScore);
        showScore(playerName, myScore);
    }

    private static void showScore(String name, int score) {
        System.out.printf(WORD_THAT_USER_SCORE, name, score);
    }

    private static int selectHitOrStand(List<String> hand, int score) {

        return score;
    }

    private static boolean isBust(int myScore2) {
        return false;
    }

    private static boolean isBlackJack(List<String> myHand2) {
        return true;
    }

    private static void showHands(List<String> myCards,
            List<String> dealerCards) {
        for (int i = 0; i < MAX_DEALS; i++) {
            System.out.printf(WORD_THAT_BE_DEALT_MY_CARD, myCards.get(i));
            System.out.printf(WORD_THAT_BE_DEALT_DEALER_CARD,
                    dealerCards.get(i));
        }

        show(BLANK_LINE);
    }

    private static void deal(List<String> hand1, List<String> hand2) {
        for (int i = 0; i < MAX_DEALS; i++) {
            hand1.add(FACE_CARDS[RAND.nextInt(CARD_NUM)]);
            hand2.add(FACE_CARDS[RAND.nextInt(CARD_NUM)]);
        }
    }

    private static int receiveCoins(int bets, double rate) {
        return (int) (bets * rate);
    }
}
