package com.example.adwise.exceptions;

public class ExpiredRefreshTokenException extends Exception {
    public ExpiredRefreshTokenException(String msg) {
        super(msg);
    }
}
