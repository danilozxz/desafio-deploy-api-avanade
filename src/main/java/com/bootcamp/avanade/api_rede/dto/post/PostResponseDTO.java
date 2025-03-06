package com.bootcamp.avanade.api_rede.dto.post;

import java.time.LocalDateTime;

import com.bootcamp.avanade.api_rede.model.Post;

public record PostResponseDTO(Long id, String description, String image, LocalDateTime publishedAt, LocalDateTime updatedAt, Long userId) {
    public static PostResponseDTO from(Post post) {
        return new PostResponseDTO(
            post.getId(),
            post.getDescription(),
            post.getImage(),
            post.getPublishedAt(),
            post.getUpdatedAt(),
            post.getUser().getId()
        );
    }
}
