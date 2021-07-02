package br.com.heycristhian.JpaSpecification.handler;

import br.com.heycristhian.JpaSpecification.error.RequestError;
import br.com.heycristhian.JpaSpecification.exception.NonUniqueValueException;
import br.com.heycristhian.JpaSpecification.exception.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestControllerAdvice
public class RestUserExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestValidationExceptionHandler.class);

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<RequestError> handleUserNotFoundException(ObjectNotFoundException e) {
        return handleBodyException(e, HttpStatus.NOT_FOUND, "User not found");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RequestError> handleIllegalArgumentException(IllegalArgumentException e) {
        return handleBodyException(e, HttpStatus.BAD_REQUEST, "Illegal Argument Exception");
    }

    @ExceptionHandler(NonUniqueValueException.class)
    public ResponseEntity<RequestError> handleNonUniqueValueException(NonUniqueValueException e) {
        return handleBodyException(e, HttpStatus.BAD_REQUEST, "Non Unique Value Exception");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RequestError> handleConstraintViolationException(ConstraintViolationException e) {
        return handleBodyException(e, HttpStatus.BAD_REQUEST, "Non-conforming values");
    }

    private ResponseEntity<RequestError> handleBodyException(Exception e, HttpStatus status, String title) {
        RequestError errorResponse = RequestError.builder()
                .title(title)
                .status(status.value())
                .message(e.getLocalizedMessage())
                .localDateTime(LocalDateTime.now())
                .objectName(e.getClass().getName())
                .build();
        LOGGER.error(title + ": " + Arrays.toString(e.getStackTrace()));
        return ResponseEntity.status(status).body(errorResponse);
    }
}
