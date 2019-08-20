package com.consulteer.facebook.exceptions;

/**
 * Created by Milos Stambolija on 15.8.2019.
 **/
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
