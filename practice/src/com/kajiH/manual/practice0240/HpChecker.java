package com.kajiH.manual.practice0240;

import java.util.Random;

/**
 * HpChecker
 */
public class HpChecker {

    private static int HP_RANGE = 10;

    public static void main(String[] args) {
        Random rand = new Random();
        int hp;

        do {
            hp = rand.nextInt(HP_RANGE);
            System.out.printf("HP => %d: ", hp);

            if (isDead(hp)) {
                System.out.printf("死んでます\n");
                break;
            }

            System.out.printf("生きてます\n");

        } while (!isDead(hp));
    }

    private static boolean isDead(int hp) {
        if (hp != 0)
            return false;

        return true;
    }
}