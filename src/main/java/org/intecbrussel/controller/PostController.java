package org.intecbrussel.controller;

import org.intecbrussel.model.Comment;
import org.intecbrussel.model.Post;
import org.intecbrussel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> findAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("{id}/comments")
    public List<Comment> getAllComments(@PathVariable Long id){
        return postService.findAllByPostId(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post){
        return postService.addPost(post);
    }

    @PostMapping("{postId}")
    public Post postComment(@PathVariable Long postId){
        return postService.findPostById(postId);
    }


    @PutMapping("{postId}")
    public Post updatePost(@PathVariable Long postId, @RequestBody Post post){
        return postService.updatePost(postId, post);
    }

    @DeleteMapping("{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }

}
