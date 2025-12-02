package org.intecbrussel.bootstrap;

import org.intecbrussel.model.Comment;
import org.intecbrussel.model.Post;
import org.intecbrussel.repository.CommentRepository;
import org.intecbrussel.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Deze class is een @Bean --> zoadat de main schoon blijft !!
public class DataLoader implements CommandLineRunner {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public DataLoader(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Post post1 = new Post();
        post1.setTitle("Mijn eerste Post");
        post1.setContent("Hello Spring Boot");
        postRepository.save(post1);

        Post post2 = new Post();
        post2.setTitle("Mijn tweede Post");
        post2.setContent("Hoe maak je database?");
        postRepository.save(post2);

        Comment comment1 = new Comment();
        comment1.setText("Leuke Post");
        comment1.setPost(post1);
        commentRepository.save(comment1);

        Comment comment2 = new Comment();
        comment2.setText("Leuke om het ook te weten");
        comment2.setPost(post2);
        commentRepository.save(comment2);

    }
}
