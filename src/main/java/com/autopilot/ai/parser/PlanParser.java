package com.autopilot.ai.parser;

import com.autopilot.ai.model.ExecutionPlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class PlanParser {

    public ExecutionPlan parse(
            String json)
            throws Exception {

        ObjectMapper mapper =
                new ObjectMapper();

        return mapper.readValue(
                json,
                ExecutionPlan.class);
    }
}