package com.bootcamp.avanade.api_rede.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.bootcamp.avanade.api_rede.dto.post.PostCreateDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostResponseDTO;
import com.bootcamp.avanade.api_rede.dto.post.PostUpdateDTO;
import com.bootcamp.avanade.api_rede.model.Post;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostMapper {
    
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Post map(PostCreateDTO postCreateDTO);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "image", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updatePost(PostUpdateDTO postUpdateDTO, @MappingTarget Post post);

    @Mapping(target = "userId", source =  "user.id")
    PostResponseDTO toPostResponseDTO(Post post);
}
