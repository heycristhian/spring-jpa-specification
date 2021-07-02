package br.com.heycristhian.JpaSpecification.service;

import br.com.heycristhian.JpaSpecification.entity.domain.Comment;
import br.com.heycristhian.JpaSpecification.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    public Optional<Comment> findById(UUID uuid) {
        return repository.findById(uuid);
    }

    public List<Comment> findAll() {
        return repository.findAll();
    }
}
