package br.com.heycristhian.JpaSpecification.config;

import br.com.heycristhian.JpaSpecification.entity.domain.User;
import br.com.heycristhian.JpaSpecification.entity.request.PostRequest;
import br.com.heycristhian.JpaSpecification.entity.response.PostResponse;
import br.com.heycristhian.JpaSpecification.service.CommentService;
import br.com.heycristhian.JpaSpecification.service.PostService;
import br.com.heycristhian.JpaSpecification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;
import java.util.UUID;

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
                        .id(UUID.fromString("ecd25e11-c1fa-4154-928b-be33e522ac0e"))
                        .name("Cristhian Dias")
                        .email("heycristhian@gmail.com")
                        .build()
        );

        User user2 = userService.save(
                User.builder()
                        .id(UUID.fromString("8681542b-422e-497e-a173-6ec713b4ba77"))
                        .name("Joao da Silva")
                        .email("famosojotinha@gmail.com")
                        .build()
        );

        PostResponse post = postService.save(
                PostRequest.builder()
                        .title("Can you help me?")
                        .body("I don't know how to play guitar hero.")
                        .date(ZonedDateTime.now())
                        .idUser(user.getId())
                        .build()
        );

//        Comment comment = commentService.save(
//                Comment.builder()
//                        .date(ZonedDateTime.now())
//                        .text("Call me, my number it's 11 22222222")
//                        .post(post)
//                        .user(user2)
//                        .build()
//        );
    }
}
