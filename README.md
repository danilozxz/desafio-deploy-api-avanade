# Desafio Decola Tech 2025 🚀

## Diagrama de classes

```mermaid
classDiagram
    class User {
        -int id
        -string username
        -string email
        -string password
        -string createdAt
    }

    class Post {
        -int id
        -int userId
        -string description
        -string image
        -string publishedAt
        -string updatedAt
    }

    class Comment {
        -int id
        -int postId
        -int userId
        -string content
        -string createdAt
    }

    User "1" *--> "N" Post : possui
    Post "1" *--> "N" Comment : recebe
    User "1" *--> "N" Comment : escreve
```
