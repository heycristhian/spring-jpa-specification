package br.com.heycristhian.JpaSpecification.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class RequestError {
    private final int status;
    private final String title;
    private final String message;
    private final String objectName;
    private final LocalDateTime localDateTime;

}
