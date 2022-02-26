package com.kajih.play;

import java.util.Scanner;

public class Display {
    Scanner stdin = new Scanner(System.in);

    public void write() {
        System.out.println("ディスプレイ:");
        stdin.nextLine();

    }

    public void finisth() {
        System.out.println("ディスプレイ　クローズ");
        stdin.close();
    }
}