package br.com.heycristhian.JpaSpecification.service;

import br.com.heycristhian.JpaSpecification.entity.domain.Post;
import br.com.heycristhian.JpaSpecification.entity.domain.User;
import br.com.heycristhian.JpaSpecification.entity.request.PostRequest;
import br.com.heycristhian.JpaSpecification.entity.response.PostResponse;
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
public class PostService {

    @Autowired
    private PostRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    public PostResponse save(PostRequest postRequest) {
        Post post = modelMapper.map(postRequest, Post.class);
        User user = userRepository.findById(postRequest.getIdUser())
                .orElseThrow(() -> new EntityNotFoundException(postRequest.getIdUser(), "User"));
        post.setUser(user);
        return modelMapper.map(repository.save(post), PostResponse.class);
    }

    public PostResponse findById(UUID uuid) {
        Post post = repository.findById(uuid).orElseThrow(() -> new EntityNotFoundException(uuid, "Post"));
        return modelMapper.map(post, PostResponse.class);
    }

    public List<PostResponse> findAll() {
        List<PostResponse> posts = repository.findAll()
                .stream()
                .map(post -> modelMapper.map(post, PostResponse.class))
                .collect(Collectors.toList());
//        posts.forEach(post -> post.setComments(commentRepository.findByPostId(post.getId())));
        return posts;
    }
}
