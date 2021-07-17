package br.com.heycristhian.JpaSpecification.entity.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommentRequest {
    @NotNull
    private ZonedDateTime date;

    private String text;

    @NotNull
    private UUID idPost;

    @NotNull
    private UUID idUser;
}
