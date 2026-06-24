package com.autopilot.ai.service;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OllamaService {

    public String generatePlan(String requirement) {

        System.out.println();
        System.out.println("Connecting to Ollama...");

        SimpleClientHttpRequestFactory factory =
                new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(10000);
        factory.setReadTimeout(120000);

        RestTemplate restTemplate =
                new RestTemplate(factory);

        String prompt = """
You are an AI Browser Automation Planner.

Your job is to convert a natural language requirement
into a Playwright execution plan.

IMPORTANT RULES:

1. Return ONLY valid JSON.
2. Do NOT explain anything.
3. Do NOT think aloud.
4. Do NOT add markdown.
5. Do NOT add text before JSON.
6. Do NOT add text after JSON.

Locator Strategy Rules:

1. Generate the most reliable locator possible.
2. Prefer:
   - id selectors (#id)
   - name selectors
   - data-testid selectors
   - CSS selectors
3. Avoid absolute XPath.
4. Use stable locators suitable for Playwright automation.
5. If a locator cannot be confidently determined, provide the best locator strategy based on the requirement.

Supported Actions:

- navigate
- fill
- click

JSON Schema:

{
  "steps":[
    {
      "action":"",
      "locator":"",
      "value":""
    }
  ]
}

Examples:

Requirement:
Login to a website

Response:

{
  "steps":[
    {
      "action":"navigate",
      "locator":"",
      "value":"https://website-url"
    },
    {
      "action":"fill",
      "locator":"#username",
      "value":"myuser"
    },
    {
      "action":"fill",
      "locator":"#password",
      "value":"mypassword"
    },
    {
      "action":"click",
      "locator":"#login-button",
      "value":""
    }
  ]
}

Generate plan for:

""" + requirement;

        Map<String, Object> request =
                Map.of(
                        "model", "qwen3",
                        "prompt", prompt,
                        "stream", false,
                        "think", false
                );

        long startTime =
                System.currentTimeMillis();

        System.out.println("Sending Request To Ollama...");

        Map<?, ?> response =
                restTemplate.postForObject(
                        "http://localhost:11434/api/generate",
                        request,
                        Map.class);

        long endTime =
                System.currentTimeMillis();

        System.out.println();
        System.out.println(
                "OLLAMA RESPONSE TIME : "
                        + ((endTime - startTime) / 1000.0)
                        + " sec");

        String generatedResponse =
                response.get("response")
                        .toString();

        System.out.println();
        System.out.println("===== GENERATED PLAN =====");
        System.out.println(generatedResponse);
        System.out.println("==========================");
        System.out.println();

        return generatedResponse;
    }
}