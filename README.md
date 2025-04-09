<p align="center">
    <img src="https://assets.dio.me/xpMN4YI-bOqGIvgjN36_JYWEwE3f9h0ZgKTISyQ7-Nw/f:webp/q:80/w:480/L3RyYWNrcy8xNTliNTRkMS1iYmY0LTRmNzItYTcxNy02OTM5OGE3YWE2ODMucG5n" width="200px">
</p>


# Decola.feed
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)


Esse projeto é uma API RestFull contruída com **Java, Spring Boot, PostgresSQL como banco de dados, Railway para hospedagem e Swagger para documentar e consumir a API.**

A API foi criada como parte do desafio do programa Decola Tech 2025 da Avanade e simula a dinâmica de uma rede social corporativa, permitindo a interação entre três entidades principais: **Usuário, Postagem e Comentário**.

## ↗️Diagrama de classes

```mermaid
classDiagram
direction LR
    class Post {
	    - Long id;
	    - Long userId;
	    - String description;
        - String image;
        - LocalDateTime publishedAt;
        - LocalDateTime updatedAt;
        - List<Comment> comments;
    }

    class User {
	    - Long id;
        - String username;
        - String email;
        - String password;
        - LocalDateTime createdAt;
        - UserRole role;
        - List<Post> posts;
        - List<Comment> comments;
	    
    }
    
    class Comment {
	    - Long id;
	    - Long postId;
	    - Long userId;
	    - String content;
	    - LocalDateTime createdAt;
    }

    Post "1" *--> "N" Comment : recebe
    User "1" *--> "N" Post : possui
    User "1" *--> "N" Comment : escreve
```

## 📍API Endpoints
A API fornece os seguintes endpoints:

#### Usuário
```markdown
GET /users/{id} - Retorna o usuário pelo ID especificado

PUT /users/{id} - Atualiza o usuário pelo ID especificado

DELETE /users/{id} - Deleta o usuário pelo ID especificado

GET /users - Retorna a lista de usuários

POST /users - Registra um novo usuário
```

#### Postagem

```markdown
GET /posts/{id} - Retorna o post pelo ID especificado

PUT /posts/{id} - Atualiza o post pelo ID especificado

DELETE /post/{id} - Deleta o post pelo ID especificado

GET /posts - Retorna a lista de posts

POST /posts - Registra um novo post
```

#### Comentário

```markdown
GET /comments/{id} - Retorna o comentário pelo ID especificado

PUT /comments/{id} - Atualiza o comentário pelo ID especificado

DELETE /comments/{id} - Deleta o comentário pelo ID especificado

GET /comments - Retorna a lista de comentários

POST /comments - Registra um novo comentário
```

## 👉Exemplos de Get e Post da entidade User 
<h3>GET /users</h3>

**RESPONSE**
```json
{
  "id": 1,
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
