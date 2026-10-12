# Remaining work for the complete enterprise edition

- Organization, user, membership, project and project-member schema.
- Tenant context, resource-level authorization, JWT issuer/audience validation and security tests.
- Workflow definitions, approval rules, audit service, transactional outbox and notifications.
- Private object storage, PDF/DOCX extraction, asynchronous ingestion and retry handling.
- Spring AI embedding integration, vector store configuration, permission-filtered RAG, citations and retrieval evaluation.
- Conversation persistence, AI usage quotas, tool calling and explicit confirmation for consequential actions.
- React OIDC login, project/organization/document pages and role-aware UI.
- Testcontainers, end-to-end tests, CI/CD, observability, backup/restore and production hardening.

The starter's `dev` profile intentionally permits unauthenticated requests and does not implement tenant isolation. Never expose it publicly or use confidential data until those controls are implemented.
