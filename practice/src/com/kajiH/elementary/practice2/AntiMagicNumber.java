package com.kajiH.elementary.practice2;

enum Gender {
    MAN(1, "男"),
    WOMAN(2, "女");

    private int id;
    private String gender;

    Gender(int id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    int getId() {
        return this.id;
    }

    String getGender() {
        return this.gender;
    }

}

public class AntiMagicNumber {

    public static void main(String[] args) {

        Gender gender = Gender.WOMAN;

        if (gender == Gender.WOMAN) {
            System.out.printf("私は %s です.\n", gender.getGender());
        }
    }
}