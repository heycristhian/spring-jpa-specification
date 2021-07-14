package br.com.heycristhian.JpaSpecification.controller;

import br.com.heycristhian.JpaSpecification.entity.request.PostRequest;
import br.com.heycristhian.JpaSpecification.entity.response.PostResponse;
import br.com.heycristhian.JpaSpecification.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{uuid}")
    public ResponseEntity<PostResponse> findById(@PathVariable UUID uuid) {
        PostResponse postResponse = service.findById(uuid);
        return ResponseEntity.ok(postResponse);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        List<PostResponse> responses = service.findAll();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<PostResponse> save(@RequestBody PostRequest postRequest, UriComponentsBuilder uriBuilder) {
        PostResponse response = service.save(postRequest);
        URI uri = uriBuilder.path("/api/posts/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
