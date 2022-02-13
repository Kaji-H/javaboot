package com.kajih.practice18.Config;

public enum Gender {
    MALE("オス"),
    FEMALE("メス");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getString() {
        return this.gender;
    }
}
