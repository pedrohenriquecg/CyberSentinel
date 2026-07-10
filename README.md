# CyberSentinel

CyberSentinel is a security monitoring platform designed around the core concepts of SIEM (Security Information and Event Management) systems.

The platform centralizes security events collected from distributed Python agents, processes them through a Spring Boot REST API, stores them in PostgreSQL, analyzes suspicious patterns using a rule-based detection engine, generates security alerts, and presents the results through a React dashboard.

---

## Architecture

Python Agent → Spring Boot REST API → PostgreSQL → Detection Engine → Alert Management → React Dashboard

---

## Features

- Centralized log collection
- Agent registration
- Security event ingestion
- Rule-based threat detection
- Alert generation
- Event classification
- JWT authentication
- Event filtering and search
- Security monitoring dashboard
- Dockerized deployment

---

## Technology Stack

### Backend

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT
- Maven

### Frontend

- React
- TypeScript
- Tailwind CSS
- Axios
- Recharts

### Database

- PostgreSQL

### Agent

- Python

### Infrastructure

- Docker
- Docker Compose

---

## Repository Structure

```text
CyberSentinel/
├── backend/
├── frontend/
├── agent/
├── docs/
```

---

## Project Status

Currently under active development.

---

## Ethical Notice

CyberSentinel is a defensive security monitoring platform.

It does not perform exploitation, unauthorized scanning, credential attacks, or malicious activities. All detection scenarios are based on simulated logs and controlled environments.