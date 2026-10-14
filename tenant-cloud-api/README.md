# Atomity 🚀
> A secure, multi-tenant cloud workload management backend built with modern Enterprise Java.

## 🌟 Overview
**Atomity** is a lightweight, secure multi-tenant backend service designed for cloud workload orchestration. It implements robust security controls and strict data isolation per tenant, leveraging cutting-edge enterprise features with Java 25 and Spring Boot 4.

## 🛠️ Tech Stack
- **Core**: Java 25, Spring Boot 4.1.1
- **Security**: Spring Security, JJWT (v0.12+) for Stateless JWT Authentication
- **Data Layer**: Spring Data JPA, PostgreSQL + Flyway
- **Architecture**: Stateless, Multi-tenant Data Partitioning (`tenantId` isolation)

## 📐 Architecture & Key Features
1. **Stateless JWT Authentication**:
   - Custom `JwtAuthFilter` and `JwtUtil` handle token generation, parsing, and signature verification using HMAC-SHA cryptographic keys.
2. **Strict Multi-Tenancy Data Isolation**:
   - Each `Workload` entity is strictly tied to a unique `tenantId`.
   - Incoming requests automatically extract the tenant context from the authentication layer, preventing cross-tenant data access and modification.

## 🚀 Getting Started

### Prerequisites
- Java 25 SDK installed
- Gradle / Maven installed

### Running the Application
1. Clone the repository:
   ```bash
   git clone [https://github.com/ian666-maker/atomity.git](https://github.com/ian666-maker/atomity.git)
   cd atomity