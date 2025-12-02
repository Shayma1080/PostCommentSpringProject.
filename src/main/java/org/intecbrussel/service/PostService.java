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
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public void addPost(Post post){
        postRepository.save(post);
    }
    public List<Post> findAll(){
        return postRepository.findAll();
    }
    public Post findById(Long id){
        return postRepository.findById(id).get();
    }
    public Post updatePost(Long id, Post post){
        Optional<Post> newPost = postRepository.findById(post.getId());
        if(newPost.isPresent()){
            Post existingPost = newPost.get();
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());
            existingPost.setDescription(post.getDescription());
            return postRepository.save(existingPost);
        }else{
            return null;
        }
    }
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }

    public List<Comment> findAllByPostId(Long id){

    }

}
