# Приклади запитів — Заняття 1/2 (повний CRUD, кіномагазин)

Бек має бути запущений: `./mvnw spring-boot:run` (порт 8080, JDK 21).

Шість операцій: перелік, фільтр за жанром, один фільм, створення, оновлення, видалення.

> На Windows (cmd / Git Bash) кирилиця в аргументах `curl` може псуватися (`????`).
> Тоді надсилайте тіло з UTF-8 файлу (`--data-binary @body.json`), кодуйте параметр
> (`?genre=%D0%94%D1%80%D0%B0%D0%BC%D0%B0`) або використовуйте Postman.

---

## 1. Перелік фільмів

```bash
curl http://localhost:8080/api/movies
```

Очікувано: масив карток `{id, title, director, price, posterUrl}`.

## 2. Перелік із фільтром за жанром

```bash
curl "http://localhost:8080/api/movies?genre=Драма"
```

Поверне лише фільми цього жанру (без урахування регістру).

## 3. Один фільм з деталями

```bash
curl http://localhost:8080/api/movies/1
```

## 4. Фільм, якого немає → 404

```bash
curl -i http://localhost:8080/api/movies/999
```

Очікувано: `HTTP/1.1 404`.

## 5. Створити фільм (POST → 201 Created)

```bash
curl -i -X POST http://localhost:8080/api/movies \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Дюна",
    "director": "Дені Вільнев",
    "price": 209.00,
    "releaseYear": 2021,
    "durationMinutes": 155,
    "posterUrl": "/posters/interstellar.svg",
    "stills": ["/stills/interstellar-1.svg"],
    "description": "Пол Атрід опиняється на пустельній планеті Арракіс.",
    "genre": "Наукова фантастика",
    "ageRating": "12+"
  }'
```

Очікувано: `HTTP/1.1 201` і JSON створеного фільму з призначеним `id`.

## 6. Оновити фільм (PUT → 200 OK)

```bash
curl -i -X PUT http://localhost:8080/api/movies/1 \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Тіні забутих предків (реставрація)",
    "director": "Сергій Параджанов",
    "price": 159.00,
    "releaseYear": 1965,
    "durationMinutes": 97,
    "posterUrl": "/posters/tini.svg",
    "stills": ["/stills/tini-1.svg"],
    "description": "Відреставрована версія фільму.",
    "genre": "Драма",
    "ageRating": "12+"
  }'
```

Очікувано: `HTTP/1.1 200` і JSON оновленого фільму.

## 7. Оновити неіснуючий фільм → 404

```bash
curl -i -X PUT http://localhost:8080/api/movies/999 \
  -H "Content-Type: application/json" \
  -d '{ "title": "X", "price": 1, "genre": "Y" }'
```

Очікувано: `HTTP/1.1 404`.

## 8. Видалити фільм (DELETE → 204 No Content)

```bash
curl -i -X DELETE http://localhost:8080/api/movies/2
```

Очікувано: `HTTP/1.1 204` (без тіла).

## 9. Видалити неіснуючий фільм → 404

```bash
curl -i -X DELETE http://localhost:8080/api/movies/999
```

Очікувано: `HTTP/1.1 404`.

## 10. Постери й кадри віддаються як статика

```bash
curl -i http://localhost:8080/posters/tini.svg
```

Очікувано: `HTTP/1.1 200` і `Content-Type: image/svg+xml`.
