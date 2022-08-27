package com.kajih.practice02;

import java.io.FileNotFoundException;

public class CheckedExceptionDemo {
    private static final String MESSAGE_FORMAT_FOR_OCCURED_EXCEPTION = "%s が発生しました %n";
    private static final String MESSAGE_FOR_EXTENDS_THROWABLE = "Throwable を継承しています";
    private static final String MESSAGE_FOR_NOT_EXTENDS_THROWABLE = "Throwable を継承していません";
    private static final String MESSAGE_FOR_UNCHECKED_EXCEPTION = "非チェック例外です";
    private static final String MESSAGE_FOR_NOT_UNCHECKED_EXCEPTION = "非チェック例外ではありません";
    private static final String PATH_FOR_READ_FILE = "./test.txt";

    public static void main(String[] args) {
        // ここに処理を書く
        showOccuredException(new NumberFormatException());
        showIsExtendsThrowable(new NumberFormatException());
        showIsUncheckedException(new NumberFormatException());
    }

    private static void showOccuredException(Exception e) {
        System.out.format(MESSAGE_FORMAT_FOR_OCCURED_EXCEPTION,
                e.getClass().getSimpleName());
    }

    private static void showIsExtendsThrowable(Exception e) {
        if (e instanceof Throwable) {
            System.out.println(MESSAGE_FOR_EXTENDS_THROWABLE);
            return;
        }
        System.out.println(MESSAGE_FOR_NOT_EXTENDS_THROWABLE);
    }

    private static void showIsUncheckedException(Exception e) {
        if (e instanceof RuntimeException) {
            System.out.println(MESSAGE_FOR_UNCHECKED_EXCEPTION);
            return;
        }
        show(MESSAGE_FOR_NOT_UNCHECKED_EXCEPTION);
    }

    private static void show(String message) {
        System.out.println(message);
    }
}
