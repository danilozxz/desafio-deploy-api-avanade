package com.bootcamp.avanade.api_rede.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.bootcamp.avanade.api_rede.dto.comment.CommentCreateDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentResponseDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentUpdateDTO;
import com.bootcamp.avanade.api_rede.model.Comment;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CommentMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "post", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Comment map(CommentCreateDTO commentCreateDTO);
    
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "post", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateComment(CommentUpdateDTO commentUpdateDTO, @MappingTarget Comment comment);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "postId", source = "post.id")
    CommentResponseDTO toCommentResponseDTO(Comment comment);
}
