package com.bootcamp.avanade.api_rede.service.impl;

import java.util.List;

import com.bootcamp.avanade.api_rede.exceptions.comment.CommentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.avanade.api_rede.dto.comment.CommentCreateDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentResponseDTO;
import com.bootcamp.avanade.api_rede.dto.comment.CommentUpdateDTO;
import com.bootcamp.avanade.api_rede.mapper.CommentMapper;
import com.bootcamp.avanade.api_rede.model.Comment;
import com.bootcamp.avanade.api_rede.model.Post;
import com.bootcamp.avanade.api_rede.model.User;
import com.bootcamp.avanade.api_rede.repository.CommentRepository;
import com.bootcamp.avanade.api_rede.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private PostServiceImpl postServiceImpl;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public Comment findById(Long id) {
        return findCommentById(id);
    }

    @Override
    public List<CommentResponseDTO> findAll() {
        return commentRepository.findAll().stream().map(commentMapper::toCommentResponseDTO).toList();
    }

    @Override
    public Comment create(CommentCreateDTO commentCreateDTO) {
        User user = userServiceImpl.findUserById(commentCreateDTO.userId());

        Post post = postServiceImpl.findPostById(commentCreateDTO.postId());

        Comment comment = commentMapper.map(commentCreateDTO);
        comment.setUser(user);
        comment.setPost(post);

        return commentRepository.save(comment);
    }

    @Override
    public CommentResponseDTO update(CommentUpdateDTO commentUpdateDTO, Long id) {
        Comment comment = findCommentById(id);
        commentMapper.updateComment(commentUpdateDTO, comment);

        return commentMapper.toCommentResponseDTO(commentRepository.save(comment));
    }

    @Override
    public void delete(Long id) {
        findCommentById(id);
        commentRepository.deleteById(id);
    }

    private Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException(id));
    }

}
