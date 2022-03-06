package com.kajih.practice22.input;

import java.util.Scanner;

import com.kajih.practice22.config.Message;

public class Inputter {
    private Scanner stdin = new Scanner(System.in);
    private Validator validator = new Validator();

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
            System.out.printf(Message.PLEASE_INPUT_NUM);
            return numInRange(min, max);
        }

        int num = Integer.parseInt(line);

        if (!validator.isInRange(num, min, max)) {
            System.out.printf(Message.PLEASE_INPUT_IN_RANGE, min, max);
            return numInRange(min, max);
        }

        return num;
    }

}
