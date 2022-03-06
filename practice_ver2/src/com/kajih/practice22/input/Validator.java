package com.kajih.practice22.input;

public class Validator {

    public boolean isInteger(String line) {
        try {
            Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean isInRange(int num, int min, int max) {
        if (num < min || num > max) {
            return false;
        }

        return true;
    }

}
