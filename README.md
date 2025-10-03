# Todo Backend (Java + Spring Boot) - Docker Compose + Postgres

Pequeno backend em Java com 2 endpoints para todos (listagem e criação), persistindo em Postgres. Pronto para rodar com Docker Compose.

## Endpoints
- `GET /todos` - lista todos os todos.
- `POST /todos` - cria um todo. JSON body: `{ "name": "..." }`

## Como rodar (com Docker)
1. Build e up:
```bash
docker compose up --build
```
O app ficará disponível em `http://localhost:8080` e o Postgres em `localhost:5432` (internamente no compose o serviço do Postgres se chama `db`).

## Testes rápidos
Criar:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"name":"compras"}' http://localhost:8080/todos
```
Listar:
```bash
curl http://localhost:8080/todos
```

## Subir num repositório git
```bash
git init
git add .
git commit -m "Initial Todo backend"
# crie um repo remoto no GitHub e depois:
git branch -M main
git remote add origin https://github.com/<seu-usuario>/<seu-repo>.git
git push -u origin main
```

---
Arquivos incluídos:
- `Dockerfile` - build multi-stage com Maven
- `docker-compose.yml` - app + postgres
- `pom.xml` - dependências Spring Boot
- `src/` - código fonte Java (Spring Boot)
- `application.properties` - configuração de conexão ao Postgres (pela compose)
