package org.intecbrussel.service;

import org.intecbrussel.model.Comment;
import org.intecbrussel.model.Post;
import org.intecbrussel.repository.CommentRepository;
import org.intecbrussel.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment addComment(Long postid, Comment comment){
        Post post = postRepository.findById(postid).orElseThrow(() -> new RuntimeException("Post not found"));
        comment.setPost(post); // link leggen
        //post.getComments().add(comment); // niet verplicht, maar proper
        return commentRepository.save(comment); // enkel nieuw comment opslaan
    }

    public Comment updateComment(Long id, Comment newComment){
        Optional<Comment> comment = commentRepository.findById(id);
        if(comment.isPresent()){
            Comment existComment = comment.get();
            existComment.setText(newComment.getText());
            return commentRepository.save(existComment);
        }else{
            return null;
        }
    }

    public void deleteComment(Long commentid){
        commentRepository.deleteById(commentid);
    }
}
