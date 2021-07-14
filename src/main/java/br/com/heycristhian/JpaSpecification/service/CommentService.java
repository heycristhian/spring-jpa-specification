package br.com.heycristhian.JpaSpecification.service;

import br.com.heycristhian.JpaSpecification.entity.domain.Comment;
import br.com.heycristhian.JpaSpecification.entity.domain.Post;
import br.com.heycristhian.JpaSpecification.entity.domain.User;
import br.com.heycristhian.JpaSpecification.entity.request.CommentRequest;
import br.com.heycristhian.JpaSpecification.entity.response.CommentResponse;
import br.com.heycristhian.JpaSpecification.exception.EntityNotFoundException;
import br.com.heycristhian.JpaSpecification.repository.CommentRepository;
import br.com.heycristhian.JpaSpecification.repository.PostRepository;
import br.com.heycristhian.JpaSpecification.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    public CommentResponse findById(UUID uuid) {
        Comment comment = repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException(uuid, "Comment"));
        return modelMapper.map(comment, CommentResponse.class);
    }

    public List<CommentResponse> findAll() {
        return repository.findAll()
                .stream().map(comment -> modelMapper.map(comment, CommentResponse.class))
                .collect(Collectors.toList());
    }

    public CommentResponse save(CommentRequest commentRequest) {
        User user = userRepository.findById(commentRequest.getIdUser())
                .orElseThrow(() -> new EntityNotFoundException(commentRequest.getIdUser(), "User"));

        Post post = postRepository.findById(commentRequest.getIdPost())
                .orElseThrow(() -> new EntityNotFoundException(commentRequest.getIdPost(), "Post"));

        Comment comment = repository.save(Comment.builder()
                .date(commentRequest.getDate())
                .text(commentRequest.getText())
                .user(user)
                .post(post)
                .build());

        return modelMapper.map(comment, CommentResponse.class);
    }
}
