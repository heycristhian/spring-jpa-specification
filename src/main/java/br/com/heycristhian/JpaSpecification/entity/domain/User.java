package br.com.heycristhian.JpaSpecification.entity.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Setter
    private String name;
    @Setter
    private String email;
}
