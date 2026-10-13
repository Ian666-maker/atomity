# Atomity 🚀
> A secure, multi-tenant cloud workload management backend built with modern Enterprise Java.

## 🌟 Overview
**Atomity** is a lightweight, secure multi-tenant backend service designed for cloud workload orchestration. It implements robust security controls and strict data isolation per tenant, leveraging modern Spring Boot 3 enterprise features.

## 🛠️ Tech Stack
* **Core**: Java 21, Spring Boot 3
* **Security**: Spring Security 6, JJWT (v0.12+) for Stateless JWT Authentication
* **Data Layer**: Spring Data JPA, H2 Database (In-Memory)
* **Architecture**: Stateless, Multi-tenant Data Partitioning (`tenantId` isolation)

## 📐 Architecture & Key Features
1. **Stateless JWT Authentication**:
    - Custom `JwtAuthFilter` and `JwtUtil` handle token generation, parsing, and signature verification using HMAC-SHA cryptographic keys.
2. **Strict Multi-Tenancy Data Isolation**:
    - Each `Workload` entity is strictly tied to a unique `tenantId`.
    - Incoming requests automatically extract the tenant context from the authentication layer, preventing cross-tenant data access and modification.

## 🚀 Getting Started

### Prerequisites
* Java 21 SDK installed
* Maven installed

### Running the Application
1. Clone the repository:

```bash
   git clone [https://github.com/ian666-maker/atomity.git](https://github.com/ian666-maker/atomity.git)
   cd atomity