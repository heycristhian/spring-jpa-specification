package br.com.heycristhian.JpaSpecification.repository;

import br.com.heycristhian.JpaSpecification.entity.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
