package com.bootcamp.avanade.api_rede.dto.comment;

import java.time.LocalDateTime;

import com.bootcamp.avanade.api_rede.model.Comment;

public record CommentResponseDTO(Long id, Long userId, Long postId, String content, LocalDateTime createdAt) {
    public static CommentResponseDTO from(Comment comment) {
        return new CommentResponseDTO(
            comment.getId(),
            comment.getUser().getId(),
            comment.getPost().getId(),
            comment.getContent(),
            comment.getCreatedAt()
        );
    }
}
