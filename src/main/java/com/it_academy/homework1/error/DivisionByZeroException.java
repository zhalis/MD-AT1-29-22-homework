package com.it_academy.homework1.error;

/**
 *Exception is thrown on division by zero
 *
 */
public class DivisionByZeroException extends RuntimeException {

    public DivisionByZeroException(String message) {
        super(message);
    }
}
