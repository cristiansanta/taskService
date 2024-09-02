package com.mindhub.taskservice.handlers;

public class NotFoundTask extends RuntimeException {
    public NotFoundTask(String message) {
        super(message);
    }
}