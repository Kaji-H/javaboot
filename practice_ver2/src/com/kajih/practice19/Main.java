package com.kajih.practice19;

import java.util.Scanner;

public class Main {

    public static Scanner STDIN = new Scanner(System.in);

    public static void main(String[] args) {
        Player player = new Player(STDIN);
        UnpopulatedIsland iland = new UnpopulatedIsland(player);

        iland.showPrologue();

        iland.spend();

        iland.showEnding();

        iland.showLog();

        STDIN.close();
    }
}