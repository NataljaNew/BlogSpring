package com.example.blogspring.controller;

import com.example.blogspring.data.Comment;
import com.example.blogspring.service.CommentService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/comments")
public class CommentController {
    public final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("create")
    public String loadCommentForm(Model model){
        model.addAttribute("comment", new Comment());
        return "comment";
    }

    @PostMapping("/create") // toki pat kaip parejo getas
    public String createComment(Comment comment, Model model){
        model.addAttribute("comment", new Comment());
        model.addAttribute("success", "");
        commentService.saveComment(comment);
        return "comment";
    }

    @GetMapping
    public String loadComments(Model model, @PageableDefault(size = 2, sort = "commentDate", direction = Sort.Direction.DESC ) Pageable pageable){
        model.addAttribute("comments", commentService.getComments(pageable));
        return "blog";
    }

    @GetMapping("/update")
    public String loadUpdateForm(@RequestParam UUID id, Model model){
        model.addAttribute("comment", commentService.getComment(id));
        return "comment";
    }

    @PostMapping("/update") //tuo paciu path is kurio atejo
    public String updateComment(Comment comment, Model model, Pageable pageable){
        commentService.updateComment(comment);
       // model.addAttribute("comments", commentService.getComments());
        return "blog";
    }

    @GetMapping("/{id}/delete")
    public String deleteComment(@PathVariable UUID id, Model model){
        commentService.deleteComment(id);
       // model.addAttribute("comments", commentService.getComments());
        return "blog";
    }

    @GetMapping("/userName/{userName}")
    public String getCommentsByUserName(@PathVariable String userName, Model model){
        model.addAttribute("comments", commentService.getAllCommentsByUserName(userName));
        return "blog";
    }
}
