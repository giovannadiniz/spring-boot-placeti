# API de Cidades

Esta API permite a manipulação de cidades.

Uma API desenvolvida com Java/Spring Boot aplicando um CRUD.

## Endpoints Disponíveis

### 1. Buscar uma cidade por ID
**Método:** GET  
**URL:** `http://localhost:8080/placeti/cidades/1`

### 2. Listar todas as cidades
**Método:** GET  
**URL:** `http://localhost:8080/placeti/cidades`

### 3. Criar uma nova cidade
**Método:** POST  
**URL:** `http://localhost:8080/placeti/cidades`

**Corpo da requisição:**
```json
{
    "nome": "Águas Lindas",
    "uf": "GO",
    "capital": false
}
```

### 4. Atualizar uma cidade existente
**Método:** PUT  
**URL:** `http://localhost:8080/placeti/cidades`

**Corpo da requisição:**
```json
{
    "id": 11,
    "nome": "Águas Lindaxx",
    "uf": "GO",
    "capital": false
}
```

### 5. Remover uma cidade por ID
**Método:** DELETE  
**URL:** `http://localhost:8080/placeti/cidades/1`

