# Atomity

**A Java backend prototype for tenant-aware workload management and JWT-based authentication.**

Atomity explores the backend building blocks behind a cloud workload management service: REST endpoints, authentication components, tenant identifiers, persistence, and database configuration.

> **Project status:** Learning / portfolio prototype. It is not production-ready. Tenant isolation and authentication enforcement need further hardening before handling real workloads or user data.

## Tech stack

- Java 25 (Gradle toolchain)
- Spring Boot 4.1.1
- Spring Security
- JJWT 0.12.5
- Spring Data JPA
- PostgreSQL
- Flyway dependencies
- Gradle Wrapper 9.7.1

## Current functionality

- `POST /api/auth/login` authenticates credentials through Spring Security and returns a JWT.
- JWT utility and authentication-filter components support token creation and request authentication.
- JWTs include a tenant identifier.
- `GET /api/workloads` retrieves workload records for a tenant.
- `POST /api/workloads` creates a workload record.
- JPA entities and repository provide the persistence layer.
- PostgreSQL connection settings are defined in the application configuration.

## Repository structure

```text
atomity/
├── README.md
└── tenant-cloud-api/
    ├── build.gradle
    ├── gradlew
    ├── settings.gradle
    └── src/
        ├── main/
        │   ├── java/com/example/tenantcloudapi/
        │   │   ├── security/
        │   │   └── workload/
        │   └── resources/application.yaml
        └── test/
```

## Run locally

### Prerequisites

- JDK 25
- PostgreSQL
- Git

### 1. Clone the repository

```bash
git clone https://github.com/Ian666-maker/atomity.git
cd atomity/tenant-cloud-api
```

### 2. Configure PostgreSQL

The current local configuration expects a database named `tenant_cloud_db` on port `54321`, with the username and password set to `postgres`.

Update `src/main/resources/application.yaml` to match your local PostgreSQL setup before running the application. Do not commit real credentials.

### 3. Start the application

On macOS / Linux:

```bash
./gradlew bootRun
```

On Windows:

```powershell
.\gradlew.bat bootRun
```

The application is configured to listen on port `8081`.

### 4. Available endpoints

| Method | Endpoint | Purpose |
| --- | --- | --- |
| POST | `/api/auth/login` | Authenticate and obtain a JWT |
| GET | `/api/workloads` | List workloads |
| POST | `/api/workloads` | Create a workload |

The login request currently accepts `username` and `password` fields. Use a configured authentication provider and valid credentials when testing.

## Engineering notes & next steps

This repository is intentionally presented as a prototype. Before treating it as a secure multi-tenant service, the following work is required:

- Enforce authentication and authorization consistently on every protected endpoint.
- Derive tenant context only from a validated security principal; remove fallback tenant behavior.
- Replace hard-coded/demo tenant assignment with a persistent user-to-tenant model.
- Move database credentials and JWT signing secrets to environment-based configuration.
- Add database migration scripts and review schema-management settings.
- Add integration tests for login, token validation, tenant boundaries, and workload CRUD.
- Add API documentation, structured logging, and CI checks.

## Author

**YiHan Diao** — Computing Science undergraduate interested in backend engineering, secure APIs, and cloud systems.

[GitHub repository](https://github.com/Ian666-maker/atomity)
