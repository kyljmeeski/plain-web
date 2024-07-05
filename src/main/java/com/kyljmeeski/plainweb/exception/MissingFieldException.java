package com.kyljmeeski.plainweb.exception;

/**
 * Exception thrown when a required field is missing or not provided.
 */
public class MissingFieldException extends Exception {

    /**
     * Constructs a MissingFieldException with the specified error message.
     *
     * @param message The error message describing the missing field issue
     */
    public MissingFieldException(String message) {
        super(message);
    }

}

