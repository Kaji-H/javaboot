package com.kajih.practice07;

public class Bird {
    protected String className;
    protected String name;

    protected Bird(String name) {
        this.name = name;
        this.className = "Bird";
    }

    public boolean isEmptyName() throws AppException {
        boolean isEmptyName = false;
        try {
            isEmptyName = this.name.equals("");
        } catch (NullPointerException e) {
            throw new AppException("UnecpectedError: 想定外の値が設定されています.");
            // throw new AppException(e);
        }
        return isEmptyName;
    }

    public void fly() {
        System.out.format(
                "[%s] %s が飛んだ. %n",
                this.className, this.name);
    }

    public static Pigeon convertToPigeon(Bird bird) throws AppException {
        Pigeon pigeon;
        try {
            pigeon = (Pigeon) bird;
        } catch (ClassCastException e) {
            throw new AppException("IncorrectHandlingError: 間違った処理が行われました.");
        }
        return pigeon;
    }
}
