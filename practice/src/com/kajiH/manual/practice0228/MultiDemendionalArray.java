package com.kajiH.manual.practice0228;

/**
 * MultiDemendionalArray
 */
public class MultiDemendionalArray {

    private final static int MAX_HORIZONTAL_INDEX = 4;
    private final static int MAX_VERTICAL_INDEX = 3;
    private final static int HORIZONTAL_INDEX = 2;
    private final static int VERTICAL_INDEX = 1;

    public static void main(String[] args) {
        int[][] dimArray = new int[MAX_HORIZONTAL_INDEX][MAX_VERTICAL_INDEX];

        for (int i = 0; i < MAX_HORIZONTAL_INDEX; i++) {
            for (int j = 0; j < MAX_VERTICAL_INDEX; j++) {
                dimArray[i][j] = i + MAX_HORIZONTAL_INDEX * j + 1;
            }
        }

        System.out.printf("水平方向(X)に%d、垂直方向(Y)に%dのインデックスにある値　=> %d\n",
                HORIZONTAL_INDEX, VERTICAL_INDEX,
                dimArray[HORIZONTAL_INDEX][VERTICAL_INDEX]);

    }
}