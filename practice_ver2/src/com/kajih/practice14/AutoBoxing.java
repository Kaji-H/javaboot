package com.kajih.practice14;

public class AutoBoxing {
    public static void main(String[] args) {
        int numInt = 12;
        Integer numInteger = 12;

        System.out.println(makeAutoBoxing(numInt));
        System.out.println(makeUnBoxing(numInteger));
    }

    private static Integer makeAutoBoxing(int numInt) {
        return numInt;
    }

    private static int makeUnBoxing(Integer numInteger) {
        return numInteger;
    }
}
