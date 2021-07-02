package br.com.heycristhian.JpaSpecification.controller;

import br.com.heycristhian.JpaSpecification.entity.domain.Post;
import br.com.heycristhian.JpaSpecification.exception.ObjectNotFoundException;
import br.com.heycristhian.JpaSpecification.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{uuid}")
    public Post findById(@PathVariable UUID uuid) {
        return service.findById(uuid).orElseThrow(() -> new ObjectNotFoundException(uuid));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> findAll() {
        return service.findAll();
    }
}
