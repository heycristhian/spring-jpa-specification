package br.com.heycristhian.JpaSpecification.repository;

import br.com.heycristhian.JpaSpecification.entity.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
}
