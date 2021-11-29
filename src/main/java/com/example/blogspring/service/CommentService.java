package com.example.blogspring.service;

import com.example.blogspring.data.Comment;
import com.example.blogspring.exception.CommentNotExistException;
import com.example.blogspring.repositories.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        comment.setCommentDate(formatter.format(date));
        commentRepository.save(comment);
    }
    public Page<Comment> getComments(Pageable pageable){

        return commentRepository.findAll(pageable);
    }

    public Comment getComment(UUID id){
        return commentRepository.findById(id).orElseThrow(CommentNotExistException :: new);
    }

    public void updateComment(Comment comment){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        comment.setCommentDate(formatter.format(date));
        commentRepository.save(comment);
    }
    public void deleteComment(UUID id){

        commentRepository.deleteById(id);
    }

    public List<Comment> getAllCommentsByUserName( String userName){
        return commentRepository.findAllByUserName(userName);
    }
}
