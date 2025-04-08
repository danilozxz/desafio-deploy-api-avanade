package com.bootcamp.avanade.api_rede.service.impl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.bootcamp.avanade.api_rede.exceptions.post.PostNotFoundException;
import com.bootcamp.avanade.api_rede.exceptions.post.PostNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.avanade.api_rede.dto.post.PostCreateDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostResponseDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostUpdateDTO;
import com.bootcamp.avanade.api_rede.mapper.PostMapper;
import com.bootcamp.avanade.api_rede.model.Post;
import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.repository.PostRepository;
import com.bootcamp.avanade.api_rede.service.PostService;

@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired 
    private PostMapper postMapper;
    
    @Override
    public Post findById(Long id) {
        return findPostById(id);
    }

    @Override
    public List<PostResponseDTO> findAll() {
        return postRepository.findAll().stream().map(postMapper::toPostResponseDTO).toList();
    }

    @Override
    public Post create(PostCreateDTO postCreateDTO) {
        validatePost(postCreateDTO.description(), postCreateDTO.image());
        User user = userServiceImpl.findUserById(postCreateDTO.userId());

        Post post = postMapper.map(postCreateDTO);
        post.setUser(user);

        return postRepository.save(post);
    }

    @Override
    public PostResponseDTO update(PostUpdateDTO postUpdateDTO, Long id) {
        validatePost(postUpdateDTO.description());
        Post post = findPostById(id);
        postMapper.updatePost(postUpdateDTO, post);
        post.setUpdatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        return postMapper.toPostResponseDTO(postRepository.save(post));
    }

    @Override
    public void delete(Long id) {
        findPostById(id);
        postRepository.deleteById(id);
    }

    public Post findPostById (Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }

    public void validatePost(String description, String image) {
        if((description == null || description.isEmpty()) && (image == null || image.isEmpty())) {
            throw new PostNullException();
        }
    }

    public void validatePost(String description) {
        if(description == null || description.isEmpty()) {
            throw new PostNullException();
        }
    }
}
