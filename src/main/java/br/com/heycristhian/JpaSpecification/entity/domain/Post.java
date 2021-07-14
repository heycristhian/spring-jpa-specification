package br.com.heycristhian.JpaSpecification.entity.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name = "tb_post")
@AllArgsConstructor
@NoArgsConstructor
public class Post implements Serializable {

    @Id
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private ZonedDateTime date;
    private String title;
    private String body;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Comment> comments;
}
