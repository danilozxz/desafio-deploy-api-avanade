package com.bootcamp.avanade.api_rede.controller;

import java.util.List;

import com.bootcamp.avanade.api_rede.controller.openAPI.PostControllerOpenAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.avanade.api_rede.dto.post.PostCreateDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostResponseDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostUpdateDTO;
import com.bootcamp.avanade.api_rede.service.PostService;


@RestController
@RequestMapping("/posts")
public class PostController implements PostControllerOpenAPI {
    
    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> findById(@PathVariable Long id) {
        var post = service.findById(id);
        var response = PostResponseDTO.from(post);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("")
    public ResponseEntity<List<PostResponseDTO>> findAll() {
        var listPosts = service.findAll();
        return ResponseEntity.ok().body(listPosts);
    }

    @PostMapping("")
    public ResponseEntity<PostResponseDTO> createPost(@RequestBody PostCreateDTO postToCreate) {
        var createdPost = service.create(postToCreate);
        var response = PostResponseDTO.from(createdPost);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePost(@RequestBody PostUpdateDTO postUpdateDTO, @PathVariable Long id) {
        var postUpdated = service.update(postUpdateDTO, id);
        return ResponseEntity.ok().body(postUpdated);
    }
}
