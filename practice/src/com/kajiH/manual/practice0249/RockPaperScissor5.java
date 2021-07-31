package com.kajiH.manual.practice0249;

public class RockPaperScissor5 {
    public static void main(String[] args) {
        int round = 1;
        int winCount = 0;

        show("じゃんけん勝負\n");
        showSelectMenu(HAND_NAME);
        showSelectMenu(DIRECTION_NAME);
        showBlankLine(1);

        while (isInMaxRound(round)) {
            showRound(round);
            show("じゃんけん...:\n");
            int[] eachHands = getEachHandsWishoutAiko();
            showWordThatSelected(HAND_NAME, eachHands);

            if (isAiko(eachHands)) {
                continue;
            }
            boolean junkenResult = getJankenResult(eachHands);

            show("あっち向いて...：");
            int[] eachDirection = getEachDirection();

            if (!isSameDirection(eachDirection)) {
                continue;
            }

            if (isWin(junkenResult)) {
                winCount++;
            }

            round++;
        }

        finalResult(winCount);

    }
}
