package com.bootcamp.avanade.api_rede.service;

import com.bootcamp.avanade.api_rede.dto.post.PostCreateDTO;
import com.bootcamp.avanade.api_rede.model.Post;

public interface PostService {
    
    Post findById(Long id);
    
    Post create(PostCreateDTO postCreateDTO);
    
}
