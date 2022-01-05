package com.kajih.practice12.practice12_2;

public interface MyData {

    public static void showResultValidate(int i, String nullMessage) {
        System.out.printf("[%d] ", i);

        if (nullMessage == null || nullMessage.isEmpty()) {
            System.out.printf("値が設定されていません.\n");
            return;
        }

        System.out.printf("値が設定されています.\n");
        return;
    }

}
