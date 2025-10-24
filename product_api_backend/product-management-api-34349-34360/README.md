# product-management-api-34349-34360

## Product Management API (Spring Boot)

This backend provides CRUD endpoints for managing products:
- POST /products
- GET /products
- GET /products/{id}
- PUT /products/{id}
- DELETE /products/{id}

Entity fields:
- id (Long)
- name (String, required, not blank)
- price (BigDecimal, >= 0)
- quantity (Integer, >= 0)

### Run and Docs
- Health: /health
- Swagger UI: /swagger-ui.html
- OpenAPI JSON: /openapi.json
- Convenience redirect to docs: /docs

Uses H2 in-memory DB by default with JPA ddl-auto=update.

### Sample cURL
Create:
curl -X POST -H "Content-Type: application/json" -d '{"name":"Keyboard","price":49.99,"quantity":10}' http://localhost:3001/products

List:
curl http://localhost:3001/products

Get:
curl http://localhost:3001/products/1

Update:
curl -X PUT -H "Content-Type: application/json" -d '{"name":"Mechanical Keyboard","price":59.99,"quantity":8}' http://localhost:3001/products/1

Delete:
curl -X DELETE http://localhost:3001/products/1
