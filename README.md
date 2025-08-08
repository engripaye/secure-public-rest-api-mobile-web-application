# 🔐 secure-public-rest-api-mobile-web-application

A secure, scalable, and production-ready REST API designed for public access via web and mobile applications. Built using **Java 21**, **Spring Boot 3.5**, and protected with **OAuth2 Bearer Token (JWT)** authentication to ensure safe and authorized interactions.

---

## 📖 Table of Contents

- [📖 Table of Contents](#-table-of-contents)
- [🚀 Features](#-features)
- [🔧 Tech Stack](#-tech-stack)
- [🔐 Security Architecture](#-security-architecture)
- [🛠️ Installation](#️-installation)
- [⚙️ Configuration](#️-configuration)
- [📦 API Endpoints](#-api-endpoints)
- [🧪 Testing the API](#-testing-the-api)
- [💡 Use Cases](#-use-cases)
- [📁 Project Structure](#-project-structure)
- [📌 Best Practices](#-best-practices)
- [📃 License](#-license)

---

## 🚀 Features

- ✅ Secure public REST API for mobile and web apps
- 🔐 OAuth2.0 Authentication using Bearer JWT tokens
- 🧑‍💻 Role-Based Access Control (RBAC) with scopes
- 🌐 CORS configuration for frontend/mobile clients
- 📈 Metrics and request logging
- 🛡️ Input validation and global exception handling
- 🚀 Deployed-ready for cloud or containerized environments

---

## 🔧 Tech Stack

| Layer           | Technology                  |
|----------------|-----------------------------|
| Language        | Java 21                     |
| Framework       | Spring Boot 3.5             |
| Security        | Spring Security, OAuth2     |
| Auth Provider   | Auth0 / Keycloak / Okta     |
| Token Format    | JWT                         |
| Database        | MySQL / PostgreSQL / MongoDB|
| Frontend Ready  | Web (React/HTML), Mobile    |
| Deployment      | Docker, CI/CD               |

---

## 🔐 Security Architecture


[Mobile/Web App] → [API Gateway] → [REST API]
    |                    |
    |                   ⬇
    |          OAuth2 Bearer Token (JWT)
    |                    |
[Auth Server] ← Validates Token


* Users authenticate via external provider (e.g. Auth0, Keycloak)
* Token is sent with `Authorization: Bearer <token>` in API calls
* Spring Security validates the token via the configured issuer
* RBAC enforced via `@PreAuthorize`, scopes, or roles in the token

---

## 🛠️ Installation

### Prerequisites

* Java 21+
* Maven or Gradle
* Auth0 or Keycloak configured
* Docker (optional)

### Clone the Repository


git clone https://github.com/engripaye/secure-public-rest-api-mobile-web-application.git
cd secure-public-rest-api-mobile-web-application


### Run the App

bash
./mvnw spring-boot:run

Or with Docker:

bash
docker build -t secure-api .
docker run -p 8080:8080 secure-api


---

## ⚙️ Configuration

Update your `application.yml`:

yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://your-auth-domain/


If using Auth0:

yaml
spring.security.oauth2.resourceserver.jwt.issuer-uri=https://dev-xxxxx.us.auth0.com/



## 📦 API Endpoints

| Method | Endpoint         | Description             | Role        |
| ------ | ---------------- | ----------------------- | ----------- |
| GET    | /api/public      | Open to all             | Public      |
| GET    | /api/user/me     | Authenticated user info | ROLE\_USER  |
| GET    | /api/admin/users | List all users          | ROLE\_ADMIN |
| POST   | /api/data/submit | Submit form data        | ROLE\_USER  |

🔐 **All protected routes require JWT in headers:**


Authorization: Bearer <access_token>


---

## 🧪 Testing the API

### Get Token

Use Postman or cURL to obtain a token from your Auth provider.

### Send Authenticated Request

bash
curl -H "Authorization: Bearer <token>" http://localhost:8080/api/user/me


### Swagger UI (Optional)

If enabled:

bash
http://localhost:8080/swagger-ui/index.html


---

## 💡 Use Cases

* 🔐 Public-facing APIs for mobile/web apps
* 🛡️ Secure microservices in distributed architecture
* 📲 API gateway integration with token-based auth
* 👥 Multi-role systems with admin/user permissions

---

## 📁 Project Structure


src/
├── main/
│   ├── java/com/example/secureapi/
│   │   ├── controller/
│   │   ├── config/
│   │   ├── service/
│   │   ├── model/
│   │   └── SecureApiApplication.java
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/com/example/secureapi/


---

## 📌 Best Practices

* Use HTTPS in production
* Never expose private keys or secrets
* Use environment variables for secrets
* Token expiration + refresh flow recommended
* Enable logging and monitoring (e.g. ELK, Prometheus)

---

## 📃 License

This project is licensed under the [MIT License](LICENSE).

---

## 🙌 Contribution

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 👨‍💻 Author

Built with ❤️ by Engr. Ipaye(https://github.com/engripaye)

```

```
