package com.bootcamp.avanade.api_rede.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.avanade.api_rede.dto.comment.CommentCreateDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentResponseDTO;
import com.bootcamp.avanade.api_rede.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> findById(@PathVariable Long id) {
        var comment = commentService.findById(id);
        var response = CommentResponseDTO.from(comment);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/add")
    public ResponseEntity<CommentResponseDTO> create(@RequestBody CommentCreateDTO commentToCreateDTO) {
        var postCreated = commentService.create(commentToCreateDTO);
        var response = CommentResponseDTO.from(postCreated);

        return ResponseEntity.ok().body(response);
    }
}
