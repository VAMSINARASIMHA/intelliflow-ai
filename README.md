# IntelliFlow AI — Starter Project

Advanced Java/Spring portfolio starter: Spring Boot REST API, MySQL/Flyway, Spring Data JPA, JDBC reporting, Spring Security OAuth2 resource-server profile, Spring AI chat endpoint, and React dashboard.

**Scope note:** This is a runnable foundation, not the entire enterprise system described in the blueprint. Organization/tenant isolation, full workflow engine, document ingestion, vector RAG, robust authorization, and production hardening remain roadmap work. Do not expose the development profile publicly.

## Requirements
- Java 25+
- Maven 3.9+
- Docker
- Node.js 20+

## Run
1. Copy `.env.example` to `.env` and change local passwords.
2. `docker compose up -d mysql`
3. `cd backend && mvn spring-boot:run`
4. In another terminal: `cd frontend && npm install && npm run dev`
5. Open http://localhost:5173

Backend: http://localhost:8080  
Health: http://localhost:8080/actuator/health

Configure `OPENAI_API_KEY` before using the AI endpoint. Never commit API keys.

## Example APIs
- `POST /api/v1/tasks` — `{"title":"Build RAG ingestion","priority":"HIGH"}`
- `GET /api/v1/tasks`
- `PATCH /api/v1/tasks/{id}/status` — `{"status":"IN_PROGRESS"}`
- `GET /api/v1/reports/overdue`
- `POST /api/v1/ai/chat` — `{"message":"Suggest a weekly project report structure"}`

## Security
The default `dev` profile permits requests for local experimentation only. The non-dev profile requires `OIDC_ISSUER_URI` and validates JWTs. This starter does not yet implement tenant isolation or full authorization; do not use real confidential data until those controls are added and tested.

## Next milestones
1. Organization/user/membership/project schema and tenant-aware authorization.
2. Workflow definitions, approvals, audit events and transactional outbox.
3. Private object storage and asynchronous PDF/DOCX extraction.
4. Spring AI embeddings, vector store, permission-filtered retrieval and citations.
5. OIDC frontend integration, integration/E2E tests, CI/CD and monitoring.
