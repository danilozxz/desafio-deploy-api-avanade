package com.bootcamp.avanade.api_rede.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.bootcamp.avanade.api_rede.dto.post.PostCreateDTO;
import com.bootcamp.avanade.api_rede.model.Post;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {
    
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "publishedAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Post map(PostCreateDTO postCreateDTO);
}
