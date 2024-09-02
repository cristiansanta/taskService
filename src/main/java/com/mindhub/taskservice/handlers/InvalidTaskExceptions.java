package com.mindhub.taskservice.handlers;

public class InvalidTaskExceptions extends RuntimeException {
    public InvalidTaskExceptions(String message) {
        super(message);
    }
}