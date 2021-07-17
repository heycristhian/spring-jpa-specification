package br.com.heycristhian.JpaSpecification.repository;

import br.com.heycristhian.JpaSpecification.entity.domain.Comment;
import br.com.heycristhian.JpaSpecification.entity.request.CommentRequest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

import static org.springframework.data.jpa.domain.Specification.where;

abstract public class CommentSpecification {

    public static Specification<Comment> filter(CommentRequest request) {
        return where(likePostId(request.getIdPost()))
                .and(likeUserId(request.getIdUser()))
                .and(likeDate(request.getDate()));
    }

    private static Specification<Comment> likePostId(UUID id) {
        return (Root<Comment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            if (Objects.isNull(id)) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("post").get("id"), id);
        };
    }

    private static Specification<Comment> likeUserId(UUID id) {
        return (Root<Comment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            if (Objects.isNull(id)) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("user").get("id"), id);
        };
    }

    private static Specification<Comment> likeDate(ZonedDateTime date) {
        return (Root<Comment> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            if (Objects.isNull(date)) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("date"), date);
        };
    }
}
