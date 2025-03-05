package com.bootcamp.avanade.api_rede.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.avanade.api_rede.dto.post.PostCreateDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostResponseDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostUpdateDTO;
import com.bootcamp.avanade.api_rede.mapper.PostMapper;
import com.bootcamp.avanade.api_rede.model.Post;
import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.repository.PostRepository;
import com.bootcamp.avanade.api_rede.repository.UserRepository;
import com.bootcamp.avanade.api_rede.service.PostService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired 
    private UserRepository userRepository;

    @Autowired 
    private PostMapper postMapper;
    
    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<PostResponseDTO> findAll() {
        return postRepository.findAll().stream().map(postMapper::toPostResponseDTO).toList();
    }

    @Override
    public Post create(PostCreateDTO postCreateDTO) {
        User user = userRepository.findById(postCreateDTO.userId())
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));

        Post post = postMapper.map(postCreateDTO);
        post.setUser(user);

        return postRepository.save(post);
    }

    @Override
    public PostResponseDTO update(PostUpdateDTO postUpdateDTO, Long id) {
        Post post = postRepository.findById(id).orElseThrow(NoSuchElementException::new);
        postMapper.updatePost(postUpdateDTO, post);

        return postMapper.toPostResponseDTO(postRepository.save(post));
    }

    @Override
    public void delete(Long id) {

        if(!postRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário com o ID especificado não encontrado");
        }

        postRepository.deleteById(id);
    }
    
}
