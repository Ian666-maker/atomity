# Atomity 🚀
> A secure cloud workload management backend built with modern Enterprise Java.

## 🌟 Overview
**Atomity** is a lightweight, secure backend service designed for cloud workload orchestration. It implements robust enterprise security controls and data management, leveraging cutting-edge enterprise features with Java 25 and Spring Boot 4.

## 🛠️ Tech Stack
- **Core**: Java 25, Spring Boot 4.1.1
- **Security**: Spring Security, JJWT (v0.12+) for Stateless JWT Authentication
- **Data Layer**: Spring Data JPA, PostgreSQL + Flyway Migration
- **Architecture**: Stateless REST API backend designed for secure cloud workload management

## 📐 Architecture & Key Features
1. **Stateless JWT Authentication**:
   - Custom authentication filters and utility components handle token generation, parsing, and signature verification using HMAC-SHA cryptographic keys.
2. **Enterprise Data Layer**:
   - Integrated with PostgreSQL and managed via automated Flyway database migrations for robust schema versioning.
3. **Core Services**:
   - Structured exception handling, validation, and production-grade baseline structure for cloud workload handling.

## 🚀 Getting Started

### Prerequisites
- Java 25 SDK installed
- Gradle / Maven installed
- Local PostgreSQL instance running

### Running the Application
1. Clone the repository:
   ```bash
   git clone [https://github.com/ian666-maker/atomity.git](https://github.com/ian666-maker/atomity.git)
   cd atomity
