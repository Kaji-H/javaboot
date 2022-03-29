package com.kajih.practice04;

public class AppException extends Exception {
    private static final long serialVersionUID = 1L;

    public AppException(String msg) {

        super(msg);
    }

    private boolean isValidFirstName(String firstName) {
        return firstName != null
                && !firstName.isEmpty();
    }

    private boolean isValidLastName(String lastName) {
        return lastName != null
                && !lastName.isEmpty();
    }
}
