package com.kajih.practice07;

public class AppException extends Exception {
    private static final long serialVersionUID = 1L;

    public AppException(String msg) {
        super(msg);
    }

    public AppException(Exception e) {
        super(e.getClass().getName());
    }
}
