package br.com.heycristhian.JpaSpecification.controller;

import br.com.heycristhian.JpaSpecification.entity.domain.User;
import br.com.heycristhian.JpaSpecification.entity.request.UserRequest;
import br.com.heycristhian.JpaSpecification.exception.ObjectNotFoundException;
import br.com.heycristhian.JpaSpecification.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<User> findById(@PathVariable UUID uuid) {
        User user = service.findById(uuid).orElseThrow(() -> new ObjectNotFoundException(uuid));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        return ResponseEntity.ok(service.save(user));
    }
}
