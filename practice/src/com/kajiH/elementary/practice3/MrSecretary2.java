package com.kajiH.elementary.practice3;

public class MrSecretary2 {

    private static final String MESSAGE_THAT_PAYMENT = "男性： %d 円\n女性： %d 円\n";
    private static final String MESSAGE_THAT_REMAINDER = "余り： %d 円\n";

    public static void main(String[] args) {
        int totalPrice = 2001;
        int numberOfMale = 3;
        int numberOfFemale = 3;
        int payingMore = 1000;

        showCalResultOfSplitBill(totalPrice, numberOfMale, numberOfFemale);
        showCalResultOfSplitBillWithMenPayingMore(totalPrice, numberOfMale, numberOfFemale, payingMore);

    }

    private static void showCalResultOfSplitBill(int totalPrice, int numberOfMale, int numberOfFemale) {
        int totalPeople = numberOfMale + numberOfFemale;
        int paymentPerPerson = totalPrice / totalPeople;
        int remainder = totalPrice % totalPeople;

        showSplitBill(paymentPerPerson, paymentPerPerson);

        if (hasRemainder(remainder)) {
            showRemainder(remainder);
        }

    }

    private static void showCalResultOfSplitBillWithMenPayingMore(int totalPrice, int numberOfMale, int numberOfFemale,
            int payingMore) {

        int totalPayingMoreWithMale = payingMore * numberOfMale;
        int totalPeople = numberOfMale + numberOfFemale;
        int paymentPerPerson = (totalPrice - totalPayingMoreWithMale) / totalPeople;
        int malePayment = paymentPerPerson + payingMore;
        int remainder = totalPrice % totalPeople;

        if (isOverTotalPrice(totalPrice, totalPayingMoreWithMale)) {
            paymentPerPerson = 0;
            malePayment = totalPrice / numberOfMale;
            remainder = totalPrice % malePayment;
        }

        showSplitBill(malePayment, paymentPerPerson);

        if (hasRemainder(remainder)) {
            showRemainder(remainder);
        }
    }

    private static void showSplitBill(int malePayment, int femalePayment) {
        System.out.printf(MESSAGE_THAT_PAYMENT, malePayment, femalePayment);
    }

    private static void showRemainder(int remainder) {
        System.out.printf(MESSAGE_THAT_REMAINDER, remainder);
    }

    private static boolean hasRemainder(int remainder) {
        return remainder > 0;
    }

    private static boolean isOverTotalPrice(int totalPrice, int totalPayingMoreWithMale) {
        return totalPrice < totalPayingMoreWithMale;
    }

}
