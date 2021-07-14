package br.com.heycristhian.JpaSpecification.entity.response;

import br.com.heycristhian.JpaSpecification.entity.domain.Post;
import br.com.heycristhian.JpaSpecification.entity.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {
    private UUID id;
    private ZonedDateTime date;
    private String text;
    private Post post;
    private User user;
}
