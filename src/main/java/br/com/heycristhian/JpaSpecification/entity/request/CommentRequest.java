package br.com.heycristhian.JpaSpecification.entity.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentRequest {
    private ZonedDateTime date;
    private String text;
    private UUID idPost;
    private UUID idUser;
}
