package com.bootcamp.avanade.api_rede.controller;

import java.util.List;

import com.bootcamp.avanade.api_rede.controller.openAPI.CommentControllerOpenAPI;
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

import com.bootcamp.avanade.api_rede.dto.comment.CommentCreateDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentResponseDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentUpdateDTO;
import com.bootcamp.avanade.api_rede.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController implements CommentControllerOpenAPI {
    
    @Autowired
    private CommentService commentService;

    
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> findById(@PathVariable Long id) {
        var comment = commentService.findById(id);
        var response = CommentResponseDTO.from(comment);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("")
    public ResponseEntity<List<CommentResponseDTO>> findAll() {
        var listComments = commentService.findAll();
        return ResponseEntity.ok().body(listComments);
    }

    @PostMapping("")
    public ResponseEntity<CommentResponseDTO> create(@RequestBody CommentCreateDTO commentToCreateDTO) {
        var postCreated = commentService.create(commentToCreateDTO);
        var response = CommentResponseDTO.from(postCreated);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> update(@RequestBody CommentUpdateDTO commentUpdateDTO, @PathVariable Long id) {
        var commentUpdated = commentService.update(commentUpdateDTO, id);

        return ResponseEntity.ok().body(commentUpdated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }
}
