# Приклади запитів — Заняття 1/1 (кіномагазин)

Бек має бути запущений: `./mvnw spring-boot:run` (порт 8080).

На 1/1 лише **два GET-ендпоінти** (перегляд). Створення фільмів — на 1/2.

---

## 1. Список фільмів (картки)

```bash
curl http://localhost:8080/api/movies
```

Очікувана відповідь (скорочено):
```json
[
  { "id": 1, "title": "Тіні забутих предків", "director": "Сергій Параджанов", "price": 149.00, "posterUrl": "/posters/tini.svg" },
  { "id": 2, "title": "Земля", "director": "Олександр Довженко", "price": 99.00, "posterUrl": "/posters/zemlia.svg" }
]
```

Красивий вивід (якщо встановлено `jq`):
```bash
curl -s http://localhost:8080/api/movies | jq
```

---

## 2. Один фільм з постером, кадрами та деталями

```bash
curl http://localhost:8080/api/movies/1
```

Очікувана відповідь:
```json
{
  "id": 1,
  "title": "Тіні забутих предків",
  "director": "Сергій Параджанов",
  "price": 149.00,
  "releaseYear": 1965,
  "durationMinutes": 97,
  "posterUrl": "/posters/tini.svg",
  "stills": ["/stills/tini-1.svg", "/stills/tini-2.svg"],
  "description": "Поетична історія кохання Івана та Марічки на тлі гуцульських Карпат.",
  "genre": "Драма",
  "ageRating": "12+"
}
```

---

## 3. Фільм, якого немає → 404

```bash
curl -i http://localhost:8080/api/movies/999
```

Очікувано: перший рядок `HTTP/1.1 404`.

---

## 4. Постери й кадри віддаються як статика

```bash
curl -i http://localhost:8080/posters/tini.svg
curl -i http://localhost:8080/stills/tini-1.svg
```

Очікувано: `HTTP/1.1 200` і `Content-Type: image/svg+xml`.
