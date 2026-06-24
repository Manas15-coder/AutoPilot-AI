# 🚀 AutoPilot AI

## Overview

AutoPilot AI is an Agentic AI-powered browser automation platform that converts natural language requirements into executable Playwright automation plans using a **free local LLM (Ollama + Qwen3)**.

Instead of writing automation scripts manually, users simply describe the task in plain English and AutoPilot AI generates an execution plan and performs browser automation automatically.


---

## ✨ Key Features

- Natural Language → Browser Automation
- AI Generated Execution Plans
- Playwright Browser Automation
- Spring Boot Backend
- Modern Web UI
- Local AI Execution
- No API Keys Required
- No Usage Costs
- Fully Offline Capable
- Extensible Agentic AI Architecture

<img width="955" height="470" alt="image" src="https://github.com/user-attachments/assets/56ee6054-9172-47b1-9ad0-58c767f0d8b6" />

---

## 🛠️ Tech Stack

| Component | Technology |
|------------|------------|
| Language | Java 17 |
| Framework | Spring Boot |
| AI Model | Ollama (Qwen3) |
| Automation | Playwright |
| JSON Processing | Jackson |
| UI | Thymeleaf, HTML, CSS, JavaScript |
| Build Tool | Maven |

---

## 🔄 High Level Flow

```text
Natural Language Requirement
                ↓
          UI Controller
                ↓
          Agent Service
                ↓
          Ollama Service
                ↓
      Qwen3 Local LLM
                ↓
     AI Generated JSON Plan
                ↓
          Plan Parser
                ↓
       Execution Plan
                ↓
     Playwright Executor
                ↓
      Browser Automation
                ↓
       Execution Result
                ↓
               UI
```

---

## 📋 Example Requirement

```text
Login to SauceDemo using standard_user and secret_sauce
```

Generated Plan:

```json
{
  "steps": [
    {
      "action": "navigate",
      "locator": "",
      "value": "https://www.saucedemo.com"
    },
    {
      "action": "fill",
      "locator": "#user-name",
      "value": "standard_user"
    },
    {
      "action": "fill",
      "locator": "#password",
      "value": "secret_sauce"
    },
    {
      "action": "click",
      "locator": "#login-button",
      "value": ""
    }
  ]
}
```

---

## ⚙️ Setup

### 1. Install Java 17

```bash
java -version
```

### 2. Install Maven

```bash
mvn -version
```

### 3. Install Ollama

Visit:

https://ollama.com

### 4. Pull Qwen3 Model

```bash
ollama pull qwen3
```

### 5. Start Ollama

```bash
ollama serve
```

### 6. Install Playwright Browsers

```bash
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```

### 7. Run Application

```bash
mvn spring-boot:run
```

### 8. Open Application

```text
http://localhost:8080
```

---

## 🎯 Use Cases

### Web Application Testing

- Login Validation
- Checkout Flow Automation
- Search Validation
- User Registration
- End-to-End Testing

### Browser Automation

- Form Submission
- Data Entry
- Repetitive Tasks
- Workflow Automation

### Agentic AI Research

- AI Planning Agents
- Task Execution Agents
- LLM Orchestration
- Autonomous Browser Agents

---

## 💰 Free & Local AI

AutoPilot AI uses:

```text
Ollama + Qwen3
```

Benefits:

✅ No OpenAI API Key

✅ No Claude API Key

✅ No Gemini API Key

✅ No Token Costs

✅ No Monthly Charges

✅ Fully Offline Execution

✅ Privacy Friendly

All AI planning is performed locally on the developer machine without sending any data to external AI providers.

---

## 🚀 Advantages Over Traditional Automation

| Traditional Automation | AutoPilot AI |
|------------------------|--------------|
| Manual Script Writing | Natural Language Input |
| Hardcoded Workflows | AI Generated Plans |
| High Maintenance | Dynamic Planning |
| Framework Expertise Required | User Friendly |
| Slow Development | Rapid Automation Creation |

---

## 🏗️ Architecture Highlights

- Agentic AI-Based Planning
- Modular Spring Boot Architecture
- Dynamic JSON Execution Plans
- Local LLM Orchestration
- Real Browser Automation
- Extensible Design for Multi-Agent Systems
- Playwright Execution Engine

---

## 🔮 Future Enhancements

### Phase 2

- OpenAI Integration
- Claude Integration
- Gemini Integration

### Phase 3

- DOM Discovery Agent
- Locator Intelligence Agent
- Self-Healing Locators

### Phase 4

- Screenshot Analysis
- Visual Validation
- AI Assertions

### Phase 5

- Docker Support
- CI/CD Integration
- Kubernetes Deployment
- Cloud Hosting

---

## 📝 Resume Description

> Built AutoPilot AI, an Agentic AI-powered browser automation platform using Java, Spring Boot, Playwright, and Ollama (Qwen3), enabling natural-language-driven automation through AI-generated execution plans. Implemented local LLM orchestration, dynamic JSON planning, and browser task execution without relying on external APIs or paid AI services.

---

## 👨‍💻 Author

AutoPilot AI demonstrates how Agentic AI can bridge the gap between Natural Language Understanding and Browser Automation by combining LLM-based planning with Playwright-based execution using a completely local AI stack.
