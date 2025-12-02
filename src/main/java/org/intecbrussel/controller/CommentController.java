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
    public Comment getComment(@PathVariable Long id, @RequestBody Comment comment){
        return commentService.addComment(id,comment);
    }

    @PutMapping("/{updateId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment comment){
        return commentService.updateComment(commentId,comment);
    }

    @DeleteMapping("/{deleteId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

}
