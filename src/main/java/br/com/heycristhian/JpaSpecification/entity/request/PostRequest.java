package br.com.heycristhian.JpaSpecification.entity.request;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private UUID idUser;
    private ZonedDateTime date;
    private String title;
    private String body;
}
