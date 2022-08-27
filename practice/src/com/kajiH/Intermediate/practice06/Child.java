package com.kajiH.Intermediate.practice06;

public class Child {

    private static final int CHILD_BORDER = 18;

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        validAge(age);

        this.age = age;
    }

    private void validAge(int age) {
        if (isNegativeNum(age)) {
            throw new IllegalArgumentException("年齢は整数で指定してください.\n");
        }
        if (!isChildAge(age)) {
            String message = String.format("年齢は %d 未満で指定してください.\n", CHILD_BORDER);
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isChildAge(int age) {
        return CHILD_BORDER > age;
    }

    private boolean isNegativeNum(int age) {
        return 0 > age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void showDetails() {
        System.out.printf("%s は %d 歳です.\n", this.name, this.age);
    }

}
