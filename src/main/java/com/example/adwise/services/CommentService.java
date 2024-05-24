package com.example.adwise.services;

import com.example.adwise.DTO.CommentDTO;
import com.example.adwise.entities.Comment;
import com.example.adwise.exceptions.ResourceNotFoundException;
import com.example.adwise.repositories.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Iterable<CommentDTO> getAllComments() {
        Iterable<Comment> comments = commentRepository.findAll();
        List<CommentDTO> commentDTOs = new ArrayList<>();
        comments.forEach(comment -> commentDTOs.add(convertToDto(comment)));
        return commentDTOs;
    }

    public CommentDTO getCommentById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
        return convertToDto(comment);
    }

    public Iterable<CommentDTO> getCommentsByUserId(Long userId) {
        Iterable<Comment> comments = commentRepository.findCommentsByCommentedProfileProfileId(userId);
        List<CommentDTO> commentDTOs = new ArrayList<>();
        comments.forEach(comment -> commentDTOs.add(convertToDto(comment)));
        return commentDTOs;
    }

    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = convertToEntity(commentDTO);
        comment.setCreatedAt(new Date());
        Comment createdComment = commentRepository.save(comment);
        return convertToDto(createdComment);
    }

    public CommentDTO updateComment(Long id, CommentDTO commentDTO) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));

        existingComment.setAuthor(commentDTO.getAuthor());
        existingComment.setCommentedProfile(commentDTO.getCommentedProfile());
        existingComment.setContent(commentDTO.getContent());
        existingComment.setCreatedAt(commentDTO.getCreatedAt());

        Comment updatedComment = commentRepository.save(existingComment);
        return convertToDto(updatedComment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    private CommentDTO convertToDto(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setCommentId(comment.getCommentId());
        commentDTO.setAuthor(comment.getAuthor());
        commentDTO.setCommentedProfile(comment.getCommentedProfile());
        commentDTO.setContent(comment.getContent());
        commentDTO.setCreatedAt(comment.getCreatedAt());
        return commentDTO;
    }

    private Comment convertToEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setCommentId(commentDTO.getCommentId());
        comment.setAuthor(commentDTO.getAuthor());
        comment.setCommentedProfile(commentDTO.getCommentedProfile());
        comment.setContent(commentDTO.getContent());

        return comment;
    }
}