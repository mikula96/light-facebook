package com.consulteer.facebook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * Created by Milos Stambolija on 15.8.2019.
 **/

@ControllerAdvice
public class ControllerExceptionAdvice extends RuntimeException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundException(HttpServletRequest request, NotFoundException ex) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        final int statusCode = HttpStatus.NOT_FOUND.value();
        String error = HttpStatus.NOT_FOUND.getReasonPhrase();
        String uri = request.getRequestURI();
        String messages = ex.getMessage();

        ErrorDto response = new ErrorDto(statusCode, messages, uri, timestamp.toString());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequesException.class)
    public ResponseEntity<ErrorDto> badRequestException(HttpServletRequest request, BadRequesException ex){
        final int statusCode = HttpStatus.BAD_REQUEST.value();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String uri = request.getRequestURI();
        String error = HttpStatus.BAD_REQUEST.getReasonPhrase();
        String message = ex.getMessage();

        ErrorDto response = new ErrorDto(statusCode,message,uri,timestamp.toString());

        return ResponseEntity.badRequest().body(response);
    }

}
