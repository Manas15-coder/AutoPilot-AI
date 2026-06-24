package com.autopilot.ai.model;

public class ExecutionResult {

    private boolean success;
    private String message;

    public ExecutionResult() {
    }

    public ExecutionResult(
            boolean success,
            String message) {

        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}