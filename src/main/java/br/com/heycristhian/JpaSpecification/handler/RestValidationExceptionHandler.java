package br.com.heycristhian.JpaSpecification.handler;

import br.com.heycristhian.JpaSpecification.error.ErrorObject;
import br.com.heycristhian.JpaSpecification.error.RequestError;
import br.com.heycristhian.JpaSpecification.error.RequestValidError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestValidationExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestValidationExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        RequestError errorResponse = getErrorResponse(ex, status, errors);
        return ResponseEntity.status(status).body(errorResponse);
    }


    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> ErrorObject.builder()
                        .message(error.getDefaultMessage())
                        .field(error.getField())
                        .parameter(error.getRejectedValue())
                        .build())
                .collect(Collectors.toList());
    }

    private RequestError getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errors) {
        return RequestValidError.childBuilder()
                .message("There are fields with errors")
                .status(status.value())
                .title(status.getReasonPhrase())
                .objectName(ex.getBindingResult().getObjectName())
                .errors(errors)
                .localDateTime(LocalDateTime.now())
                .build();
    }


}
