package com.bootcamp.avanade.api_rede.repository;

import com.bootcamp.avanade.api_rede.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
