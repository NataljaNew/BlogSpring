package com.example.blogspring.controller;

import com.example.blogspring.data.Comment;
import com.example.blogspring.service.CommentService;
import com.example.blogspring.service.MessageService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class CommentController {
    public final CommentService commentService;
    private final MessageService messageService;

    public CommentController(CommentService commentService,MessageService messageService) {
        this.commentService = commentService;
        this.messageService = messageService;
    }

    @GetMapping("/private/comments/create")
    public String loadCommentForm(Model model, String key){
        model.addAttribute("comment", new Comment());
        if(key != null){
            model.addAttribute("success", messageService.getMessage(key));
        }
        return "comment";
    }

    @PostMapping("/private/comments/create") // toki pat kaip parejo getas
    public String createComment(@Valid Comment comment, BindingResult bindingResult){
    if(bindingResult.hasErrors()){
        return "blog";
    }
        commentService.saveComment(comment);
        return "redirect:/private/comments/create?key=comment.success";
    }

    @GetMapping("/public/comments")
    public String loadComments(Model model, @PageableDefault(size = 2, sort = "commentDate", direction = Sort.Direction.DESC ) Pageable pageable, Authorization authorization){
        model.addAttribute("pageOfComments", commentService.getComments(pageable));
        return "blog";
    }

    @GetMapping("/private/comments/update")
    public String loadUpdateForm(@RequestParam UUID id, Model model){
        model.addAttribute("comment", commentService.getComment(id));
        return "comment";
    }

    @PostMapping("/private/comments/update") //tuo paciu path is kurio atejo
    public String updateComment(Comment comment){
        commentService.updateComment(comment);
        return "redirect:/public/comments";
    }

    @GetMapping("/private/comments/{id}/delete")
    public String deleteComment(@PathVariable UUID id){
        commentService.deleteComment(id);
        return "redirect:/public/comments";
    }

    @GetMapping("/private/comments/userName/{userName}")
    public String getCommentsByUserName(@PathVariable String userName, Model model){
        model.addAttribute("comments", commentService.getAllCommentsByUserName(userName));
        return "blog";
    }

    @PostMapping("/private/comments")
    public String signOut(SessionStatus sessionStatus, RedirectAttributes redirectAttributes){
        sessionStatus.setComplete();
        redirectAttributes.addFlashAttribute("success", "user.checked.out.successfully");
        return "redirect:/public/comments";
    }
}
