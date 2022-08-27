package com.kajiH.manual.practice0236;

import java.util.Random;

public class MoreNarrowScope {
    public static void main(String[] args) {

        Random rand = new Random();
        final int RANDOM_RANGE = 10;
        int count = 0;
        boolean isHit = false;

        while (!isHit) {
            int num = rand.nextInt(RANDOM_RANGE);
            count++;
            System.out.printf("%d 回目の数字 => %d %n", count, num);
            if (num == 5)
                isHit = true;
        }
    }
}
