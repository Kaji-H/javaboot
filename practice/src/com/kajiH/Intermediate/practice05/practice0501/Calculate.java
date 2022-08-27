package com.kajiH.Intermediate.practice05.practice0501;

public class Calculate {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int[] array = { 1, 5, 9, 2, 55 };

        Adder adder = new Adder();

        adder.showResultAdded(a, b);
        adder.showResultAdded(array);

    }

}
