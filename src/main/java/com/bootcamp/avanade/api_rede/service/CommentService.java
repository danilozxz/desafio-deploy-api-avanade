package com.bootcamp.avanade.api_rede.service;

import com.bootcamp.avanade.api_rede.dto.comment.CommentCreateDTO;
import com.bootcamp.avanade.api_rede.model.Comment;

public interface CommentService {
    
    Comment findById(Long id);

    Comment create(CommentCreateDTO commentCreateDTO);
}
