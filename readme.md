# No-AI Approval Workflow

The **No-AI Approval Workflow** is a simple, customizable API-based project designed for workflows that prioritize manual or traditional decision-making processes over automated AI-driven methods. This repository demonstrates a lightweight approval system with extensibility in mind.

---

## **Features**
- **Simple API**: Provides endpoints for workflow management.
- **Fuzzy Matching**: Uses advanced algorithms (e.g., Levenshtein Distance, Cosine Similarity) for input validation.
- **Lightweight Design**: Focused on simplicity and ease of use.
- **No Database**: Runs entirely as an API service without requiring database integration.

---

## **Requirements**
- **Java**: 21 or later
- **Gradle**: 8.0 or later
- **Docker**: For containerized deployments (optional)

---

## **Getting Started**

### **Clone the Repository**
```bash
git clone https://github.com/ballance/no-ai-approval-workflow.git
cd no-ai-approval-workflow
gradle clean bootRun
```
Navigate to http://localhost:8080/matcher?input=Eggplant
