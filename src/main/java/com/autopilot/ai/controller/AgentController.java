package com.autopilot.ai.controller;

import com.autopilot.ai.model.AgentRequest;
import com.autopilot.ai.model.ExecutionResult;
import com.autopilot.ai.service.AgentService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(
            AgentService agentService) {

        this.agentService = agentService;
    }

    @PostMapping("/execute")
    public ExecutionResult execute(
            @RequestBody
            AgentRequest request)
            throws Exception {

        return agentService.runAgent(
                request.getRequirement());
    }
}