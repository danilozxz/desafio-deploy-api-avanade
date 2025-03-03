package com.bootcamp.avanade.api_rede.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity(name = "tb_posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String description;
    private String image;
    private Instant publishedAt;
    private Instant updatedAt;
}
