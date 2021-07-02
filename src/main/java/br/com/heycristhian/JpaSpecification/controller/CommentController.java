package br.com.heycristhian.JpaSpecification.controller;

import br.com.heycristhian.JpaSpecification.entity.domain.Comment;
import br.com.heycristhian.JpaSpecification.entity.domain.Post;
import br.com.heycristhian.JpaSpecification.exception.ObjectNotFoundException;
import br.com.heycristhian.JpaSpecification.service.CommentService;
import br.com.heycristhian.JpaSpecification.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{uuid}")
    public Comment findById(@PathVariable UUID uuid) {
        return service.findById(uuid).orElseThrow(() -> new ObjectNotFoundException(uuid));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Comment> findAll() {
        return service.findAll();
    }
}
