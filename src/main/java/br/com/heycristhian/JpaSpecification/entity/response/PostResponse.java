package br.com.heycristhian.JpaSpecification.entity.response;

import br.com.heycristhian.JpaSpecification.entity.domain.Comment;
import br.com.heycristhian.JpaSpecification.entity.domain.User;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private UUID id;
    private ZonedDateTime date;
    private String title;
    private String body;
    private User user;
    private List<Comment> comments;
}
