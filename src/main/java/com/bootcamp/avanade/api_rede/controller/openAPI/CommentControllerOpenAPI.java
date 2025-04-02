package com.bootcamp.avanade.api_rede.controller.openAPI;

import com.bootcamp.avanade.api_rede.dto.comment.CommentCreateDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentResponseDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Comment")
public interface CommentControllerOpenAPI {

    @Operation(summary = "Buscar comentário pelo ID")
    ResponseEntity<CommentResponseDTO> findById(Long id);

    @Operation(summary = "Listar todos comentários")
    ResponseEntity<List<CommentResponseDTO>> findAll();

    @Operation(summary = "Criar novo comentário")
    ResponseEntity<CommentResponseDTO> create(CommentCreateDTO commentToCreateDTO);

    @Operation(summary = "Deletar comentário pelo ID")
    void delete(@PathVariable Long id);

    @Operation(summary = "Atualizar comentário")
    ResponseEntity<CommentResponseDTO> update(CommentUpdateDTO commentUpdateDTO, Long id);
}
