package org.intecbrussel.controller;

import org.intecbrussel.model.Comment;
import org.intecbrussel.repository.CommentRepository;
import org.intecbrussel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;


    @PostMapping("/{postId}")
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment){
        return commentService.addComment(postId,comment);
    }

    @PutMapping("/{updateId}")
    public Comment updateComment(@PathVariable Long updateId, @RequestBody Comment comment){
        return commentService.updateComment(updateId,comment);
    }

    @DeleteMapping("/{deleteId}")
    public void deleteComment(@PathVariable Long deleteId){
        commentService.deleteComment(deleteId);
    }

}
