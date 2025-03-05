package com.bootcamp.avanade.api_rede.service;

import java.util.List;

import com.bootcamp.avanade.api_rede.dto.post.PostCreateDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostResponseDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostUpdateDTO;
import com.bootcamp.avanade.api_rede.model.Post;

public interface PostService {
    
    Post findById(Long id);
    
    List<PostResponseDTO> findAll();

    Post create(PostCreateDTO postCreateDTO);

    PostResponseDTO update(PostUpdateDTO postUpdateDTO, Long id);

    void delete(Long id);
    
}
