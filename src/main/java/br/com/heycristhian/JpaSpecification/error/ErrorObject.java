package br.com.heycristhian.JpaSpecification.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ErrorObject {
    private final String message;
    private final String field;
    private final Object parameter;
}
