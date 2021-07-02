package br.com.heycristhian.JpaSpecification.error;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class RequestValidError extends RequestError {
    private final List<ErrorObject> errors;

    @Builder(builderMethodName = "childBuilder")
    public RequestValidError(List<ErrorObject> errors, int status, String title, String message, String objectName, LocalDateTime localDateTime) {
        super(status, title, message, objectName, localDateTime);
        this.errors = errors;
    }
}
