<<<<<<< HEAD
# Destinex — Travel Planning Platform

A full-stack travel planning application with a Spring Boot REST API backend and a React frontend.

---

## Project Structure

```
Proj/
├── travel/          # Spring Boot backend (Java 17, Maven)
└── travelfrontend/  # React frontend
```

---

## Backend — Spring Boot

### Tech Stack
- Java 17, Spring Boot 3.5.5
- Spring Data JPA + Hibernate
- MySQL
- SpringDoc OpenAPI (Swagger UI)

### Features
| Module | Endpoints |
|---|---|
| Auth | Register, Login, Logout, Verify Email, Reset Password |
| Users | Profile CRUD, Change Password, Session Management |
| Itineraries | Create, Read, Update, Delete, Share |
| Bookings | Create, Read, Update, Delete, Confirmation |
| Destinations | List, Search, Activities by Destination |
| Expenses | Add, Update, Delete, Budget Summary |

### Setup

1. Create a MySQL database:
   ```sql
   CREATE DATABASE travel_db;
   ```

2. Set environment variables (or update `application.properties`):
   ```
   DB_URL=jdbc:mysql://localhost:3306/travel_db
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   ```

3. Run:
   ```bash
   cd travel
   ./mvnw spring-boot:run
   ```

4. API docs available at: `http://localhost:8080/swagger-ui/index.html`

---

## Frontend — React

### Tech Stack
- React 19, React Router v7
- Framer Motion (animations)
- Lucide React (icons)

### Setup

```bash
cd travelfrontend
npm install
npm start
```

App runs at `http://localhost:3000`

---

## API Overview

| Method | Endpoint | Description |
|---|---|---|
| POST | `/register` | Register a new user |
| POST | `/login` | Login |
| POST | `/logout/{id}` | Logout |
| GET | `/api/users/profile/{id}` | Get user profile |
| PUT | `/api/users/profile/{id}` | Update profile |
| GET | `/api/itineraries` | List all itineraries |
| POST | `/api/itineraries` | Create itinerary |
| GET | `/api/destinations` | List destinations |
| GET | `/api/destinations/search?keyword=` | Search destinations |
| POST | `/api/bookings` | Create booking |
| POST | `/api/expenses` | Add expense |
| GET | `/api/expenses/budget/{id}/summary` | Expense summary |

---

## Environment Variables

| Variable | Description |
|---|---|
| `DB_URL` | MySQL JDBC URL |
| `DB_USERNAME` | Database username |
| `DB_PASSWORD` | Database password |

> Never commit real credentials. Use environment variables or a `.env` file (add to `.gitignore`).
=======
# Projects
This repository contains all the projects i've been doing and have already done
>>>>>>> 78b6ff138a0bf3137d7fd0e57b06d6446c72d307
