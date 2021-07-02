package br.com.heycristhian.JpaSpecification.service;

import br.com.heycristhian.JpaSpecification.entity.domain.Post;
import br.com.heycristhian.JpaSpecification.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post save(Post post) {
        return repository.save(post);
    }

    public Optional<Post> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<Post> findAll() {
        return repository.findAll();
    }
}
