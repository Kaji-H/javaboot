package com.kajih.practice18;

import com.kajih.practice18.Config.FoodingType;
import com.kajih.practice18.Config.Gender;

public abstract class Animal implements Barkable {

    private String name;
    private Gender gender;
    private FoodingType feedingType;

    protected Animal(String name, Gender gender, FoodingType feedingType) {
        this.name = name;
        this.gender = gender;
        this.feedingType = feedingType;
    }

    public void eat() {
        showFeedingType();
    }

    private void showFeedingType() {
        System.out.format(
                "%s は %s ........", this.name, this.feedingType.getString());
    }

    @Override
    public String toString() {
        return String.format(
                "名前=%s::性別=%s::食性=%s",
                this.name,
                this.gender.getString(),
                this.feedingType.getString());
    }

    public void changeName(String newName) {
        this.name = newName;
    }

}
