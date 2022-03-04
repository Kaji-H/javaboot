package com.kajih.practice22.input;

import java.util.Scanner;

public class Inputter {
    Scanner stdin = new Scanner(System.in);
    Validator validator = new Validator();

    public int numInRange(int min, int max) {
        String line = stdin.nextLine();

        int num = validateNumInRange(line, min, max);

        return num;
    }

    public void close() {
        stdin.close();
    }

    private int validateNumInRange(String line, int min, int max) {
        if (!validator.isInteger(line)) {
            return numInRange(min, max);
        }

        int num = Integer.parseInt(line);

        if (!validator.isInRange(num, min, max)) {
            return numInRange(min, max);
        }

        return num;
    }

}
