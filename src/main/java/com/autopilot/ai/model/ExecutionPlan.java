package com.autopilot.ai.model;

import java.util.List;

public class ExecutionPlan {

    private List<ExecutionStep> steps;

    public List<ExecutionStep> getSteps() {
        return steps;
    }

    public void setSteps(List<ExecutionStep> steps) {
        this.steps = steps;
    }
}