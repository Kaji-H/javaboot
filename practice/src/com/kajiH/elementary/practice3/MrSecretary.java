package com.kajiH.elementary.practice3;

public class MrSecretary {

    private static int totalPrice = 3001;
    private static int numberOfMale = 3;
    private static int numberOfFemale = 3;
    private static int payingMoreMoney = 1000;

    public static void main(String[] args) {

        splitTheBill();
        splitTheBillWithMale(payingMoreMoney);

    }

    private static void splitTheBill() {
        int peopleNum = numberOfMale + numberOfFemale;
        int pricePerPerson = totalPrice / peopleNum;
        int remainder = totalPrice % peopleNum;

        showSplitTheBill(pricePerPerson, pricePerPerson, remainder);
    }

    private static void splitTheBillWithMale(int payingMoreMoney) {
        if (isOverTotalPrice(payingMoreMoney * numberOfMale)) {
            System.out.printf("男性の支払いが支払金額より多くなっています。\n");
            return;
        }

        int peopleNum = numberOfMale + numberOfFemale;
        int malesPayingPrice = payingMoreMoney * numberOfMale;
        int pricePerPerson = (totalPrice - malesPayingPrice) / peopleNum;
        int malePaying = pricePerPerson + payingMoreMoney;
        int remainder = (totalPrice - malesPayingPrice) % peopleNum;

        showSplitTheBill(malePaying, pricePerPerson, remainder);
    }

    private static boolean isOverTotalPrice(int payingMoney) {
        return payingMoney >= totalPrice;
    }

    private static void showSplitTheBill(int malePaying, int femalePaying,
            int remainder) {
        System.out.printf("男性：%d 円\n", malePaying);
        System.out.printf("女性：%d 円\n", femalePaying);

        if (remainder > 0) {
            System.out.printf("余り：%d 円\n", remainder);
        }
    }

}
