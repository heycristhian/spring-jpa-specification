package br.com.heycristhian.JpaSpecification.config;

import br.com.heycristhian.JpaSpecification.entity.domain.Comment;
import br.com.heycristhian.JpaSpecification.entity.domain.Post;
import br.com.heycristhian.JpaSpecification.entity.domain.User;
import br.com.heycristhian.JpaSpecification.service.CommentService;
import br.com.heycristhian.JpaSpecification.service.PostService;
import br.com.heycristhian.JpaSpecification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;
import java.util.ArrayList;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Override
    public void run(String... args) {
        User user = userService.save(
                User.builder()
                        .name("Cristhian Dias")
                        .email("heycristhian@gmail.com")
                        .build()
        );

        User user2 = userService.save(
                User.builder()
                        .name("Joao da Silva")
                        .email("famosojotinha@gmail.com")
                        .build()
        );

        Post post = postService.save(
                Post.builder()
                        .title("Can you help me?")
                        .body("I don't know how to play guitar hero.")
                        .date(ZonedDateTime.now())
                        .user(user)
                        .build()
        );

        Comment comment = commentService.save(
                Comment.builder()
                        .date(ZonedDateTime.now())
                        .text("Call me, my number it's 11 22222222")
                        .post(post)
                        .user(user2)
                        .build()
        );
    }
}
