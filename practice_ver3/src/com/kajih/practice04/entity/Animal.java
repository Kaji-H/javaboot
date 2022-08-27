package com.kajih.practice04.entity;

public abstract class Animal implements Barkable {

    protected static String CARNIVORE = "肉食";
    protected static String HERBIVORE = "草食";

    protected static String MALE = "オス";
    protected static String FEMALE = "メス";

    protected String name;
    protected String gender;
    protected String eatHabit;

    public Animal(String name, boolean isMale, String eatHabit) {
        this.name = name;
        this.gender = generateGender(isMale);
        this.eatHabit = eatHabit;
    }

    public abstract void eat();

    public void changeName(String name) {
        this.name = name;
    }

    public String toString() {
        return String.format("名前=%s::性別=%s::食性=%s",
                this.name, this.gender, this.eatHabit);
    }

    protected String generateGender(boolean isMale) {
        if (isMale) {
            return MALE;
        }

        return FEMALE;
    }

}
