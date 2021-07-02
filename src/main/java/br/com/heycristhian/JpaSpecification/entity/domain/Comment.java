package br.com.heycristhian.JpaSpecification.entity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_comment")
public class Comment implements Serializable {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private ZonedDateTime date;
    private String text;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;
}
