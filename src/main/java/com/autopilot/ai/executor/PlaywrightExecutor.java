package com.autopilot.ai.executor;

import com.autopilot.ai.model.ExecutionPlan;
import com.autopilot.ai.model.ExecutionResult;
import com.autopilot.ai.model.ExecutionStep;
import com.microsoft.playwright.*;

import org.springframework.stereotype.Component;

@Component
public class PlaywrightExecutor {

    public ExecutionResult execute(ExecutionPlan plan) {

        try (Playwright playwright = Playwright.create()) {

            System.out.println("Launching Browser...");

            Browser browser =
                    playwright.chromium()
                            .launch(
                                    new BrowserType.LaunchOptions()
                                            .setHeadless(false)
                            );

            Page page = browser.newPage();

            for (ExecutionStep step : plan.getSteps()) {

                String action =
                        step.getAction() == null
                                ? ""
                                : step.getAction().trim();

                String locator =
                        step.getLocator() == null
                                ? ""
                                : step.getLocator().trim();

                String value =
                        step.getValue() == null
                                ? ""
                                : step.getValue().trim();

                System.out.println(
                        "Executing Action: " + action +
                                " | Locator: " + locator +
                                " | Value: " + value);

                switch (action.toLowerCase()) {

                    case "navigate":
                    case "navigate_to_url":
                    case "open browser":
                    case "open url":

                        System.out.println(
                                "Navigating to: " + value);

                        page.navigate(value);

                        page.waitForLoadState();

                        break;

                    case "fill":
                    case "input_text":
                    case "type":

                        String fillLocator =
                                convertLocator(locator, value);

                        System.out.println(
                                "Typing into: " + fillLocator);

                        /*
                         * NOTE:
                         * Your AI currently generates:
                         *
                         * Action=Type
                         * Locator=ID
                         * Value=user-name
                         *
                         * This is not enough information
                         * to actually type text.
                         *
                         * We need AI to generate:
                         *
                         * Locator=#user-name
                         * Value=standard_user
                         */

                        if (!fillLocator.isEmpty()) {

                            page.fill(
                                    fillLocator,
                                    value);
                        }

                        break;

                    case "click":
                    case "click_element":

                        String clickLocator =
                                convertLocator(locator, value);

                        System.out.println(
                                "Clicking: " + clickLocator);

                        page.click(clickLocator);

                        break;

                    default:

                        System.out.println(
                                "Unsupported Action: "
                                        + action);
                }

                page.waitForTimeout(1000);
            }

            System.out.println("Execution Completed");

            page.waitForTimeout(10000);

            browser.close();

            return new ExecutionResult(
                    true,
                    "Execution Completed Successfully");

        } catch (Exception e) {

            e.printStackTrace();

            return new ExecutionResult(
                    false,
                    "Execution Failed: "
                            + e.getMessage());
        }
    }

    private String convertLocator(
            String locator,
            String value) {

        if (locator == null) {
            return "";
        }

        switch (locator.toUpperCase()) {

            case "ID":
                return "#" + value;

            case "NAME":
                return "[name='" + value + "']";

            case "CLASS":
                return "." + value;

            default:
                return locator;
        }
    }
}