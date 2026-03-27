# Security Event Monitor

A Spring Boot REST API for logging and retrieving security-related events such as login attempts, access denials, and API activity.

## Features

- Create and store security events
- Retrieve events by:
  - ID
  - Username
  - Event Type
  - IP Address
- Input validation with meaningful error responses
- Global exception handling (400 / 404)
- In-memory H2 database for quick testing

## Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok

## Example Endpoint

POST /api/events

```json
{
  "eventType": "LOGIN_FAILURE",
  "username": "jdoe",
  "ipAddress": "192.168.1.10",
  "userAgent": "Mozilla/5.0",
  "details": "Failed login attempt"
}
```
Future Improvements
Pagination and sorting
Security (Spring Security + JWT)
Suspicious activity detection
Unit and integration testing
