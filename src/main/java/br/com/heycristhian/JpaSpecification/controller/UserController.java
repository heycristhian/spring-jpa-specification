package br.com.heycristhian.JpaSpecification.controller;

import br.com.heycristhian.JpaSpecification.entity.domain.User;
import br.com.heycristhian.JpaSpecification.entity.request.UserRequest;
import br.com.heycristhian.JpaSpecification.entity.response.UserResponse;
import br.com.heycristhian.JpaSpecification.exception.EntityNotFoundException;
import br.com.heycristhian.JpaSpecification.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> users = service.findAll()
                .stream().map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<User> findById(@PathVariable UUID uuid) {
        User user = service.findById(uuid).orElseThrow(() -> new EntityNotFoundException(uuid, "User"));
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        return ResponseEntity.ok(service.save(user));
    }
}
