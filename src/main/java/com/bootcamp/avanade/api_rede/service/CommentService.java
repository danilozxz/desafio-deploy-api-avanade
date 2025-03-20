package com.bootcamp.avanade.api_rede.service;

import java.util.List;

import com.bootcamp.avanade.api_rede.dto.comment.CommentCreateDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentResponseDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentUpdateDTO;
import com.bootcamp.avanade.api_rede.model.Comment;

public interface CommentService {
    
    Comment findById(Long id);

    List<CommentResponseDTO> findAll();

    Comment create(CommentCreateDTO commentCreateDTO);

    CommentResponseDTO update(CommentUpdateDTO commentUpdateDTO, Long id);

    void delete(Long id);
}
