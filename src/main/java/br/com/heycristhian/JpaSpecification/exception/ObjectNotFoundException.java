package br.com.heycristhian.JpaSpecification.exception;

import java.util.UUID;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(UUID uuid) {
        super("Object not found with uuid: " + uuid);
    }
}
