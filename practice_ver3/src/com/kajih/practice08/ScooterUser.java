package com.kajih.practice08;

public class ScooterUser {
    public static void main(String[] args) {
        Scooter myScooter = new Scooter();
        myScooter.setColor("BLACK");
        myScooter.setMaxSpeed(136);
        myScooter.showBikeInfo();
        myScooter.driveStart();
        myScooter.driveStop();
    }
}
