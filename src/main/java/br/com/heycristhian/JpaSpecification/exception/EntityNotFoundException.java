package br.com.heycristhian.JpaSpecification.exception;

import java.util.UUID;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(UUID uuid, String nameEntity) {
        super(nameEntity + " not found with uuid: " + uuid);
    }
}
