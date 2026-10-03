# Friv Clone · backend

REST API for a Friv-style portal of browser games. Spring Boot 3 on Java 17, with an in-memory H2 database seeded from `data.sql`. The frontend lives in [Friv-clone-frontend](https://github.com/Yeisonfjrd/Friv-clone-frontend).

```
GET    /api/games                         list every game
GET    /api/games/{id}                    one game, 404 if it doesn't exist
POST   /api/games                         create (201)
PUT    /api/games/{id}                    replace (404 if missing)
DELETE /api/games/{id}                    204
GET    /api/games/images/games/{file}     cover images, content type from the extension
GET    /actuator/health                   used by Railway's health check
```

Controller → service → `JpaRepository`, nothing clever.

## Tracing

Every request is traced with Micrometer and exported over OTLP. `docker-compose.yml` brings up Jaeger so you can see the spans locally:

```bash
docker compose up -d        # Jaeger UI on http://localhost:16686
./mvnw spring-boot:run      # API on http://localhost:8080
```

Sampling is at 100%, which is fine for a project this size and not something I'd ship to real traffic.

## Tests

`./mvnw test` runs the controller tests (MockMvc, including the image endpoint's 404 and content-type cases) and the service tests (Mockito). CI runs them on every push.

## Known limits

- H2 in memory with `create-drop`: every restart goes back to the seed data. Good for a demo, not for anything that needs to persist.
- The entity is exposed straight through the API, no DTOs and no validation, so `POST` accepts a game with no title.
- `category` is a free string instead of an enum or its own table.

Some of the tracing and test work came in through PRs from [@Milanz505](https://github.com/Milanz505).
