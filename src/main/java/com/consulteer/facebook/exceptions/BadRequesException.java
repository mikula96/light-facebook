package com.consulteer.facebook.exceptions;

/**
 * Created by Milos Stambolija on 15.8.2019.
 **/
public class BadRequesException extends RuntimeException {
    public BadRequesException(String message) {
        super(message);
    }
}
