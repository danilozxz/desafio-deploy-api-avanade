<p align="center">
    <img src="https://assets.dio.me/xpMN4YI-bOqGIvgjN36_JYWEwE3f9h0ZgKTISyQ7-Nw/f:webp/q:80/w:480/L3RyYWNrcy8xNTliNTRkMS1iYmY0LTRmNzItYTcxNy02OTM5OGE3YWE2ODMucG5n" width="200px">
</p>


# Rede API
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)


Esse projeto é uma API RestFull contruída com **Java, Spring Boot, PostgresSQL como banco de dados, Railway para hospedagem e Swagger para documentar e consumir a API.**

A API que faz parte de um desafio do programa **Decola Tech 2025** da Avanade, simula a relação entre três entidades de uma rede social: **Usuário, Postagem e Comentário**

## 📍API Endpoints
A API fornece os seguintes endpoints:

#### Usuário
```markdown
GET /users/{id} - Retorna o usuário pelo ID especificado

GET /users/list - Retorna a lista de usuários

POST /users/add - Registra um novo usuário

PUT /users/update/{id} - Atualiza o usuário pelo ID especificado

DELETE /users/{id} - Deleta o usuário pelo ID especificado
```

#### Postagem

```markdown
GET /posts/{id} - Retorna o post pelo ID especificado

GET /posts/list - Retorna a lista de posts

POST /posts/add - Registra um novo post

PUT /posts/update/{id} - Atualiza o post pelo ID especificado

DELETE /post/{id} - Deleta o post pelo ID especificado
```

#### Comentário

```markdown
GET /comments/{id} - Retorna o comentário pelo ID especificado

GET /comments/list - Retorna a lista de comentários

POST /comments/add - Registra um novo comentário

PUT /comments/{id} - Atualiza o comentário pelo ID especificado

DELETE /comments/{id} - Deleta o comentário pelo ID especificado
```

## 👉Exemplos de Get e Post da entidade User 
<h3>GET /users</h3>

**RESPONSE**
```json
{
  "id": 1
  "username": "Danilo Fernandes",
  "email": "exemplo@gmail.com",
  "createdAt": "2025-03-19T19:28:29.456Z"
}
```
<h3>POST /users</h3>

**RESPONSE**
```json
{
  "username": "danilo",
  "email": "exemplo@gmail.com",
  "password": "string"
}
```

<h2 id="colab">🤝 Colaborador</h2>
<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/149892834?v=4" width="100px;" alt="Danilo Fernandes"/><br>
        <sub>
          <b>Danilo Fernandes</b>
        </sub>
      </a>
    </td>
  </tr>
</table>