package com.kajiH.manual.practice0240;

import java.util.ArrayList;
import java.util.List;

public class ListPrinter<E> {
    public static void main(String[] args) {
        List<String> dogType = new ArrayList<>();

        dogType.add("Chiwawa");
        dogType.add("Pomeranian");
        dogType.add("Bulldog");
        dogType.add("Akita");
        dogType.add("Poodle");

        ListPrinter<String> print = new ListPrinter<>();

        print.printAllElements(dogType);
    }

    public void printAllElements(List<E> dogType) {
        for (int i = 0; i < dogType.size(); i++) {
            System.out.printf("%d => %s\n", i, dogType.get(i));
        }
    }
}
