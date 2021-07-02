package br.com.heycristhian.JpaSpecification.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class NonUniqueValueException extends DataIntegrityViolationException {

    public NonUniqueValueException(String field, String value) {
        super("There is already registration in the database: {" + field + ": " + value + "}");
    }
}
