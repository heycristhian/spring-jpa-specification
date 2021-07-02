package br.com.heycristhian.JpaSpecification.entity.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Getter
public class UserRequest {

    @Pattern(regexp = "[A-z\\s]+")
    @Size(min = 3, max = 15, message = "{size.name}")
    @NotBlank
    private final String name;

    @Email(message = "{email}")
    private final String email;
}
