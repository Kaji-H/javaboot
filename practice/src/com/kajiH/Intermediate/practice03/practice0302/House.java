package com.kajiH.Intermediate.practice03.practice0302;

public class House {

    private static final String MESSAGE_THAT_OPEN_DOOR = "%s さんの家のドアを開けます\n";
    private static final String MESSAGE_THAT_OPENED_DOOR = " => [INFO] すでにドアは開いてます\n";
    private static final String MESSAGE_THAT_CLOSE_DOOR = "%s さんの家のドアを閉めます\n";
    private static final String MESSAGE_THAT_CLOSED_DOOR = " => [INFO] すでにドアは閉まってます\n";
    private static final String CLOSE = "閉まってます";
    private static final String OPEN = "開いてます";
    private static final String MESSAGE_THAT_OWNER = "%s さん家\n";
    private static final String MESSAGE_THAT_COLOR = " => 色：%s\n";
    private static final String MESSAGE_THAT_ADDRESS = " => 住所：%s\n";
    private static final String MESSAGE_THAT_DOOR_STATUS = " => ドア：%s\n";

    private String owner;
    private String color;
    private String address;
    private boolean isDoorOpen;

    public House(String owner, String color, String address) {
        this.owner = owner;
        this.color = color;
        this.address = address;
        this.isDoorOpen = false;
    }

    public void closeDoor() {
        System.out.printf(MESSAGE_THAT_CLOSE_DOOR, this.owner);

        if (!this.isDoorOpen) {
            System.out.printf(MESSAGE_THAT_CLOSED_DOOR);
        }

        this.isDoorOpen = false;
    }

    public void openDoor() {
        System.out.printf(MESSAGE_THAT_OPEN_DOOR, this.owner);

        if (this.isDoorOpen) {
            System.out.printf(MESSAGE_THAT_OPENED_DOOR);
        }

        this.isDoorOpen = true;
    }

    public void showDetails() {
        String message = getDoorStatus();

        System.out.printf(MESSAGE_THAT_OWNER, this.owner);
        System.out.printf(MESSAGE_THAT_COLOR, this.color);
        System.out.printf(MESSAGE_THAT_ADDRESS, this.address);
        System.out.printf(MESSAGE_THAT_DOOR_STATUS, message);
    }

    public String getOwner() {
        return this.owner;
    }

    public String getColor() {
        return this.color;
    }

    public String getAddress() {
        return this.address;
    }

    public String getDoorStatus() {
        return this.isDoorOpen ? OPEN : CLOSE;
    }
}
