# BFHL API - Acropolis Campus Hiring (May 2026)

## Overview
Spring Boot REST API for the Bajaj Finserv Health Limited (BFHL) campus hiring API round.

**Student:** Sarvesh Jadia  
**Roll Number:** 0827CS231240  
**Email:** sarveshjadia230885@acropolis.in

---

## Tech Stack
- Java 21
- Spring Boot 3.2.5
- Maven
- Lombok

## Project Structure

```
bfhl-api/
├── src/
│   ├── main/
│   │   ├── java/com/sarvesh/bfhl/
│   │   │   ├── BfhlApiApplication.java          # Entry point
│   │   │   ├── controller/
│   │   │   │   └── BfhlController.java           # POST /bfhl
│   │   │   ├── dto/
│   │   │   │   ├── BfhlRequest.java              # Request DTO
│   │   │   │   ├── BfhlResponse.java             # Response DTO
│   │   │   │   └── ErrorResponse.java            # Error DTO
│   │   │   ├── service/
│   │   │   │   ├── BfhlService.java              # Service interface
│   │   │   │   └── impl/
│   │   │   │       └── BfhlServiceImpl.java      # Service implementation
│   │   │   ├── util/
│   │   │   │   ├── DataClassifier.java           # Classification utilities
│   │   │   │   └── ConcatStringBuilder.java      # Alternating caps logic
│   │   │   └── exception/
│   │   │       └── GlobalExceptionHandler.java   # Global error handling
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/sarvesh/bfhl/
│           ├── DataClassifierTest.java
│           ├── ConcatStringBuilderTest.java
│           ├── BfhlServiceImplTest.java
│           └── BfhlControllerIntegrationTest.java
└── pom.xml
```

---

## API

### POST /bfhl

**Request:**
```json
{ "data": ["a", "1", "334", "4", "R", "$"] }
```

**Response (200 OK):**
```json
{
  "is_success": true,
  "user_id": "sarvesh_jadia_07042005",
  "email": "sarveshjadia230885@acropolis.in",
  "roll_number": "0827CS231240",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

### concat_string Logic
1. Extract all alphabetic tokens → uppercase them → join into one string
2. Reverse the full string
3. Apply alternating caps (index 0 = uppercase, index 1 = lowercase, ...)

**Example C:** `["A", "ABCD", "DOE"]` → joined = `AABCDDOE` → reversed = `EODDCBAA` → alternating = `EoDdCbAa`

---

## Build & Run

```bash
# Build
mvn clean package -DskipTests

# Run
java -jar target/bfhl-api-1.0.0.jar

# Test
curl -X POST http://localhost:8080/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data": ["a", "1", "334", "4", "R", "$"]}'
```

## Run Tests
```bash
mvn test
```

---

## Deployment on Render

1. Push to GitHub
2. Go to [render.com](https://render.com) → New → Web Service
3. Connect your GitHub repo
4. Set:
   - **Build Command:** `mvn clean package -DskipTests`
   - **Start Command:** `java -jar target/bfhl-api-1.0.0.jar`
   - **Environment:** Java (or Docker)
5. Add environment variable: `PORT=8080`
6. Deploy → your URL will be `https://your-service.onrender.com/bfhl`

## Deployment on Railway

1. Push to GitHub
2. Go to [railway.app](https://railway.app) → New Project → Deploy from GitHub
3. Railway auto-detects Spring Boot via Maven
4. Add variable: `PORT=8080`
5. Your API: `https://your-project.up.railway.app/bfhl`

---

## Exception Handling

| Scenario | HTTP Status | Response |
|---|---|---|
| Valid request | 200 | Full BfhlResponse |
| Missing `data` field | 400 | `{"is_success": false, "message": "..."}` |
| Malformed JSON | 400 | `{"is_success": false, "message": "Malformed JSON request body"}` |
| Unexpected error | 500 | `{"is_success": false, "message": "..."}` |
