package com.consulteer.facebook.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Created by Milos Stambolija on 15.8.2019.
 **/

@Getter
@Setter
@AllArgsConstructor
public class ErrorDto {
    private int statusCode;
    private String message;
    private String uri;
    private String timestamp;
}
