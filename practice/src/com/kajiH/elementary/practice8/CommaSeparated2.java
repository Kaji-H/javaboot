package com.kajiH.elementary.practice8;

public class CommaSeparated2 {
    public static void main(String[] args) {
        System.out.println(commaSeparatedString(123));
        System.out.println(commaSeparatedString(12345));
        System.out.println(commaSeparatedString(1234567));
        System.out.println(commaSeparatedString(-1234567));
        System.out.println(commaSeparatedString(123456789));
        System.out.println(commaSeparatedString(-123456789));
    }

    private static String commaSeparatedString(int num) {
        boolean isMinus = false;

        if (num < 0) {
            isMinus = true;
            num *= -1;
        }

        String strNum = String.valueOf(num);
        int digit = strNum.length();

        String str = "";

        if (isMinus) {
            str = "-";
        }

        for (int i = 0; i < digit; i++) {

            if ((digit - i) % 3 == 0 && i!=0) {
                str += ",";
            }
            str += strNum.charAt(i);
        }

        return str;
    }
}
