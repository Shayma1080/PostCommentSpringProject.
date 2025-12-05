package org.intecbrussel.service;

import org.hibernate.annotations.Comments;
import org.intecbrussel.exception.ResourceNotFoundException;
import org.intecbrussel.model.Comment;
import org.intecbrussel.model.Post;
import org.intecbrussel.repository.CommentRepository;
import org.intecbrussel.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public Post addPost(Post post){
        return postRepository.save(post);
    }
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
    public Post findPostById(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }
    public Post updatePost(Long id, Post post){
        Optional<Post> newPost = postRepository.findById(id);
        if(newPost.isPresent()){
            Post existingPost = newPost.get();
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setDescription(post.getDescription());
            return postRepository.save(existingPost);
        }else{
            throw new RuntimeException("post not found with id " + id);
        }
    }
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public List<Comment> findAllByPostId(Long id){
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("post not found"));
        return List.copyOf(post.getComments()); // converteer SET naar LIST
    }

}
