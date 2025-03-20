package com.bootcamp.avanade.api_rede.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

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
import com.bootcamp.avanade.api_rede.repository.PostRepository;
import com.bootcamp.avanade.api_rede.repository.UserRepository;
import com.bootcamp.avanade.api_rede.service.CommentService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow((NoSuchElementException::new));
    }

    @Override
    public List<CommentResponseDTO> findAll() {
        return commentRepository.findAll().stream().map(commentMapper::toCommentResponseDTO).toList();
    }

    @Override
    public Comment create(CommentCreateDTO commentCreateDTO) {
        User user = userRepository.findById(commentCreateDTO.userId())
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado"));

        Post post = postRepository.findById(commentCreateDTO.postId())
                .orElseThrow(() -> new NoSuchElementException("Postagem não encontrada"));

        Comment comment = commentMapper.map(commentCreateDTO);
        comment.setUser(user);
        comment.setPost(post);

        return commentRepository.save(comment);
    }

    @Override
    public CommentResponseDTO update(CommentUpdateDTO commentUpdateDTO, Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(NoSuchElementException::new);
        commentMapper.updateComment(commentUpdateDTO, comment);

        return commentMapper.toCommentResponseDTO(commentRepository.save(comment));
    }

    @Override
    public void delete(Long id) {

        if(!commentRepository.existsById(id)) {
            throw new EntityNotFoundException("Comentário com o ID especificado não encontrado");
        }
        commentRepository.deleteById(id);
    }

}
