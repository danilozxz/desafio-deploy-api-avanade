package com.bootcamp.avanade.api_rede.controller.openAPI;

import com.bootcamp.avanade.api_rede.dto.post.PostCreateDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostResponseDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Post")
public interface PostControllerOpenAPI {

    @Operation(summary = "Buscar post pelo ID")
    ResponseEntity<PostResponseDTO> findById(Long id);

    @Operation(summary = "Listar todos posts")
    ResponseEntity<List<PostResponseDTO>> findAll();

    @Operation(summary = "Criar novo post")
    ResponseEntity<PostResponseDTO> createPost(PostCreateDTO postToCreate);

    @Operation(summary = "Deletar post pelo ID")
    ResponseEntity<Void> deleteById(Long id);

    @Operation(summary = "Atualizar post")
    ResponseEntity<PostResponseDTO> updatePost(PostUpdateDTO postUpdateDTO, Long id);
}
