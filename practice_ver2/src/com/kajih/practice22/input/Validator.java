package com.kajih.practice22.input;

public class Validator {

    public boolean isInteger(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.printf("error1\n");
            return false;
        }
        return true;
    }

    public boolean isInRange(int num, int min, int max) {
        if (num < min || num > max) {
            System.out.printf("error2\n");
            return false;
        }

        return true;
    }

}
