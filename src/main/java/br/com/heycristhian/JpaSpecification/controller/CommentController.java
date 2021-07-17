package br.com.heycristhian.JpaSpecification.controller;

import br.com.heycristhian.JpaSpecification.entity.request.CommentRequest;
import br.com.heycristhian.JpaSpecification.entity.response.CommentResponse;
import br.com.heycristhian.JpaSpecification.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{uuid}")
    public ResponseEntity<CommentResponse> findById(@PathVariable UUID uuid) {
        CommentResponse commentResponse = service.findById(uuid);
        return ResponseEntity.ok(commentResponse);
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> findAll() {
        List<CommentResponse> comments = service.findAll();
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<CommentResponse> save(@RequestBody CommentRequest commentRequest, UriComponentsBuilder uriBuilder) {
        CommentResponse response = service.save(commentRequest);
        URI uri = uriBuilder.path("/api/comments/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<CommentResponse>> filter(@Valid CommentRequest commentRequest) {
        List<CommentResponse> comments = service.findByFilter(commentRequest);
        return ResponseEntity.ok(comments);
    }
}
