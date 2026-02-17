
# Highway Bakery Backend — Updated (Spring Boot 3)

Fixes included:
- Security config permits public GET for shops/products and order place/search/get
- Controllers use explicit `@PathVariable("...")` / `@RequestParam("...")` to avoid `-parameters` issues
- Maven compiler plugin enables `<parameters>true` (Java 17)
- H2 seed data and default admin

## Run
```bash
mvn clean spring-boot:run
```

### Public APIs
- `GET /api/shops`
- `GET /api/products/shop/{shopId}`
- `POST /api/orders`
- `GET /api/orders/search?q=...`
- `GET /api/orders/{id}`

### Admin
- `POST /api/auth/login` (admin@bakery.com / admin123)
- `GET /api/orders` (JWT)
- `PUT /api/orders/{id}/status?status=READY` (JWT)

H2 console: `/h2` (JDBC URL: `jdbc:h2:mem:bakerydb`)
