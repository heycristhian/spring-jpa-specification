package br.com.heycristhian.JpaSpecification.entity.response;

import br.com.heycristhian.JpaSpecification.entity.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponse {
    private final UUID uuid;
    private final ZonedDateTime date;
    private final String title;
    private final String body;
    private final User user;
}
